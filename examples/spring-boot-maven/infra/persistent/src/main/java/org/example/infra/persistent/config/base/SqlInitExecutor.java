package org.example.infra.persistent.config.base;

import cn.hutool.core.io.resource.ResourceUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class SqlInitExecutor {
    private ResourceLoader resourceLoader;

    private static void executeScript(Connection conn, String sqlPath, String stage) {
        try {
            String sql = ResourceUtil.readUtf8Str(sqlPath);
            log.info("\ninit {} by {}:\n{}", stage, sqlPath, sql);
            conn.createStatement().execute(sql);
            log.info("\ninit {} by {} success!", stage, sqlPath);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public List<String> listFilesInDirectory(String directoryPath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + directoryPath);
        Path path = Paths.get(resource.getURI());

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path is not a directory: " + directoryPath);
        }
        return Files.list(path)
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toList());
    }

    public void execute(DataSource dataSource, String baseDir) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            List<String> dropScripts = listFilesInDirectory(baseDir + "/teardown");
            dropScripts.forEach(e -> executeScript(conn, baseDir + "/teardown/" + e, "teardown"));

            List<String> schemaScripts = listFilesInDirectory(baseDir + "/schemas");
            schemaScripts.forEach(e -> executeScript(conn, baseDir + "/schemas/" + e, "schemas"));

            List<String> dataScripts = listFilesInDirectory(baseDir + "/data");
            dataScripts.forEach(e -> executeScript(conn, baseDir + "/data/" + e, "data"));
        }
    }
}

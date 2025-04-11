package org.example.halo.infra.persistent.config.base;


import cn.hutool.core.io.resource.ResourceUtil;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import javax.sql.DataSource;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
public class SqlInitExecutor {


    private static void executeScript(Connection conn, String sqlPath, String sql, String stage) {
        Statement statement = null;
        try {
//            String sql = ResourceUtil.readUtf8Str(sqlPath);
            log.info("\ninit {} by {}:\n{}", stage, sqlPath, sql);
            statement = conn.createStatement();
            statement.execute(sql);
            log.info("\ninit {} by {} success!", stage, sqlPath);
            statement.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

//    public List<String> listFilesInDirectory(String directoryPath) throws IOException {
//        Resource resource = resourceLoader.getResource("classpath:" + directoryPath);
//        Path path = Paths.get(resource.getURI());
//
//        if (!Files.isDirectory(path)) {
//            throw new IllegalArgumentException("Path is not a directory: " + directoryPath);
//        }
//        return Files.list(path)
//                .map(Path::getFileName)
//                .map(Path::toString)
//                .collect(Collectors.toList());
//    }

    public static Map<String, String> readResourceFiles(String dir) {
        Map<String, String> sqlFilesContent = new HashMap<>();

        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(dir);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                Path path = Paths.get(url.toURI());

                if (Files.isDirectory(path)) {
                    Files.walk(path)
                            .filter(Files::isRegularFile)
                            .forEach(file -> {
                                try {
                                    String fileName = file.getFileName().toString();
                                    String content = readFile(file);
                                    sqlFilesContent.put(fileName, content);
                                } catch (IOException e) {
                                    log.error("Error reading file: " + file, e);
                                }
                            });
                }
            }
        } catch (IOException | FileSystemNotFoundException e) {
            log.error("Error reading resources", e);
        } catch (Exception e) {
            log.error("Unexpected error", e);
        }

        return sqlFilesContent;
    }

    private static String readFile(Path file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public static void execute(DataSource dataSource, String baseDir) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            Map<String, String> dropScripts = readResourceFiles(baseDir + "/teardown");
            dropScripts.forEach((file, sql) -> executeScript(conn, baseDir + "/teardown/" + file, sql, "teardown"));

            Map<String,String> schemaScripts = readResourceFiles(baseDir + "/schemas");
            schemaScripts.forEach((file, sql) -> executeScript(conn, baseDir + "/schemas/" + file, sql, "schemas"));

            Map<String, String> dataScripts = readResourceFiles(baseDir + "/data");
            dataScripts.forEach((file, sql) -> executeScript(conn, baseDir + "/data/" + file, sql, "data"));
        }
    }
}

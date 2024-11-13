#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.config.base;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class SqlInitExecutor {

    private static void executeScript(Connection conn, String sqlPath, String stage) {
        Statement statement = null;
        try {
            String sql = ResourceUtil.readUtf8Str(sqlPath);
            log.info("${symbol_escape}ninit {} by {}:${symbol_escape}n{}", stage, sqlPath, sql);
            statement = conn.createStatement();
            statement.execute(sql);
            log.info("${symbol_escape}ninit {} by {} success!", stage, sqlPath);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
    }

    public static void execute(DataSource dataSource, String baseDir) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            executeScript(conn, baseDir + "/teardown/drop.sql", "teardown");
            executeScript(conn, baseDir + "/schemas/schema.sql", "schemas");
            executeScript(conn, baseDir + "/data/data.sql", "data");
        }
    }
}

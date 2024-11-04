#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class MyRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> findAllUsers() {
        return jdbcTemplate.queryForList("SELECT * FROM users");
    }

    public void addUser(String name, String email) {
        jdbcTemplate.update("INSERT INTO users (name, email) VALUES (?, ?)", name, email);
    }
}

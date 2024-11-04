package org.example.k8s;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ProbeController {

    private JdbcTemplate jdbcTemplate;

    @GetMapping("/startup")
    public String startup() {
        jdbcTemplate.execute("SELECT 1;");
        return "OK";
    }

    @GetMapping("/liveness")
    public String liveness() {
        return "OK";
    }

    @GetMapping("/readiness")
    public String readiness() {
        return "OK";
    }
}

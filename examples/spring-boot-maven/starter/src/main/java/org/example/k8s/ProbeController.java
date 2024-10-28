package org.example.k8s;

//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProbeController {

    @GetMapping("/liveness")
    public String liveness() {
        return "OK";
    }

    @GetMapping("/readiness")
    public String readiness() {
        return "OK";
    }
}

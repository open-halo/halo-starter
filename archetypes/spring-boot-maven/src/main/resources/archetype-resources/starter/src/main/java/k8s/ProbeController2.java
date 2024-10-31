#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.k8s;

import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

@Named
@AllArgsConstructor
@RestController
public class ProbeController2 {

    private JdbcTemplate jdbcTemplate;

    @GET
    @Path("/startup")
    public String startup() {
        jdbcTemplate.execute("SELECT 1;");
        return "OK";
    }
}

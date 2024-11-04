#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JaxrsApplication extends Application {
}

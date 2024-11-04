package org.example.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JaxrsApplication extends Application {
}

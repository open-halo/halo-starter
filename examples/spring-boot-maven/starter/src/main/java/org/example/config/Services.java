package org.example.config;

import org.example.core.gateway.repository.IUserRepository;
import org.example.core.service.IUserService;
import org.example.core.service.impl.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Services {
    @Bean
    IUserService getUserService(IUserRepository userRepository) {
        return new UserService(userRepository);
    }

}

package com.cognitio.api.model.domain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ConfiguracoesSeguranca {
@Bean
UserDetailsService userDetailsService() {
    UserDetails user = User.builder()
            .username("LM@gmail.com")
            .password("{noop}Luiz123")
            .build();
            return new InMemoryUserDetailsManager(user);
}
}
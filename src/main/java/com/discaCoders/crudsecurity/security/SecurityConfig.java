package com.discaCoders.crudsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
              configurer
                      .requestMatchers(HttpMethod.GET, "api/workers").hasAnyRole("humanResources", "workBoss")
                      .requestMatchers(HttpMethod.GET, "api/workers/**").hasAnyRole("humanResources", "workBoss")
                      .requestMatchers(HttpMethod.POST, "api/workers").hasRole("humanResources")
                      .requestMatchers(HttpMethod.PUT, "api/workers").hasRole("humanResources")
                      .requestMatchers(HttpMethod.DELETE, "api/workers/**").hasRole("humanResources")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }
}

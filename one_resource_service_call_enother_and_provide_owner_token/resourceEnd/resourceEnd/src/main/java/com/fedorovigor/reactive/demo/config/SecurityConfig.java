package com.fedorovigor.reactive.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${jwks_uri}")
    private String keysUri;

    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity http) {
        return http
                .oauth2ResourceServer(
                        j -> j.jwt().jwkSetUri(keysUri)
                )
                .authorizeExchange()
                    .pathMatchers("/products/**").authenticated()
                    .anyExchange().permitAll()
                .and()
                .build();
    }
}

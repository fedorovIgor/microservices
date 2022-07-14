package com.fedorovigor.reactive.client.config;

import com.fedorovigor.reactive.client.handlers.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RoutsConfig {

    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler) {
        return RouterFunctions.route()
                .GET("/all", productHandler::getAll)
                .GET("/testjwt", productHandler::getTest)
                .GET("/unsec", productHandler::getAllUnsecure)
                .build();
    }
}

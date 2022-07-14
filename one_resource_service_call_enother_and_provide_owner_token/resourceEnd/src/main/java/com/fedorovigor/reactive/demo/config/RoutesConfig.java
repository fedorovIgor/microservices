package com.fedorovigor.reactive.demo.config;

import com.fedorovigor.reactive.demo.handlers.ProductHandler;
import com.fedorovigor.reactive.demo.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fedorovigor.reactive.demo.models.Product;

@Configuration
public class RoutesConfig {

    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler) {
        return RouterFunctions.route()
                .GET("/products", productHandler::getAll)
                .GET("/all", productHandler::getAll)
                .build();
    }
}

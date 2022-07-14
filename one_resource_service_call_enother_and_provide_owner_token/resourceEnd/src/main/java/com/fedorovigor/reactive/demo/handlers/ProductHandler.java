package com.fedorovigor.reactive.demo.handlers;

import com.fedorovigor.reactive.demo.models.Product;
import com.fedorovigor.reactive.demo.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

    private final ProductService productService;


    public ProductHandler(ProductService productService) {
        this.productService = productService;
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.getAll(), Product.class);
    }
}

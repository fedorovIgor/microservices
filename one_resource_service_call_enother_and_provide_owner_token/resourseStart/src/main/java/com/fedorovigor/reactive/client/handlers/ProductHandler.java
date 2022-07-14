package com.fedorovigor.reactive.client.handlers;

import com.fedorovigor.reactive.client.models.Product;
import com.fedorovigor.reactive.client.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
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

    public Mono<ServerResponse> getTest(ServerRequest request) {
        ReactiveSecurityContextHolder.getContext()
                .subscribe(System.out::println);

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Mono.just("this is test data"), String.class);
    }

    public Mono<ServerResponse> getAllUnsecure(ServerRequest request) {

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.getUnsecureALL(), Product.class);
    }
}

package com.fedorovigor.reactive.client.proxy;

import com.fedorovigor.reactive.client.exceptions.ProductRetrieveException;
import com.fedorovigor.reactive.client.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductProxy {

    private final WebClient webClient;

    public ProductProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Product> getAll() {

        return  webClient.get().uri("products")
                .exchangeToFlux(res -> {
            if (! HttpStatus.OK.equals(res.statusCode())) {
                throw new ProductRetrieveException(res.statusCode().toString());
            }

            return res.bodyToFlux(Product.class);
        });

    }

    public  Flux<Product> getAllProduct() {
        return webClient.get().uri("all")
                .exchangeToFlux(res -> res.bodyToFlux(Product.class));
    }
}

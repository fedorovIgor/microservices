package com.fedorovigor.reactive.demo.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import com.fedorovigor.reactive.demo.models.Product;

import java.time.Duration;
import java.util.List;

@Service
public class ProductService {

    public Flux<Product> getAll() {
        var p1 = new Product();
        p1.setName("Bear");

        var p2 = new Product();
        p2.setName("Bread");

        Flux<Product> products =
                Flux.fromStream(List.of(p1, p2).stream())
                    .delayElements(Duration.ofSeconds(1));

        return products;
    }
}

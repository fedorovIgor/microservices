package com.fedorovigor.reactive.client.services;

import com.fedorovigor.reactive.client.models.Product;
import com.fedorovigor.reactive.client.proxy.ProductProxy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService {

    private final ProductProxy proxy;

    public ProductService(ProductProxy proxy) {
        this.proxy = proxy;
    }

    public Flux<Product> getAll() {
        return proxy.getAll();
    }

    public Flux<Product> getUnsecureALL() {
        return proxy.getAllProduct();
    }
}

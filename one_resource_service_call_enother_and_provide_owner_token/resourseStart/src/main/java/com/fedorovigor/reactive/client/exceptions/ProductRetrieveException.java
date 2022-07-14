package com.fedorovigor.reactive.client.exceptions;

public class ProductRetrieveException extends RuntimeException {
    public ProductRetrieveException(Throwable e) {
        super(e);
    }

    public ProductRetrieveException(String message) {
        super(message);
    }
}

package com.suphanBirlik.demo.rest;

public class ProductNotFoundExeption extends RuntimeException{
    public ProductNotFoundExeption(Throwable cause) {
        super(cause);
    }

    public ProductNotFoundExeption(String message) {
        super(message);
    }

    public ProductNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }
}

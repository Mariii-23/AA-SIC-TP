package com.example.backend.exception;

public class OrderAlreadyPayedException extends Exception{
    public OrderAlreadyPayedException(String message) {
        super(message);
    }
}

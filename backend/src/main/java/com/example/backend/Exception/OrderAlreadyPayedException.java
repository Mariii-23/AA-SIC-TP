package com.example.backend.Exception;

public class OrderAlreadyPayedException extends Exception{
    public OrderAlreadyPayedException(String message) {
        super(message);
    }
}

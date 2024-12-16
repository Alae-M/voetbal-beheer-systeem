package com.example.ledenservice;

public class LidNotFoundException extends RuntimeException {
    public LidNotFoundException(String message) {
        super(message);
    }
}

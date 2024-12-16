package com.example.wedstrijdservice;

public class WedstrijdNotFoundException extends RuntimeException {
    public WedstrijdNotFoundException(String message) {
        super(message);
    }
}

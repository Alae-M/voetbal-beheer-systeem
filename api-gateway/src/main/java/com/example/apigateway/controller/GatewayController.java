package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.HttpStatus;
import java.net.URI;

@RestController
public class GatewayController {

    @RequestMapping("/")
    public String redirectToHome(ServerWebExchange exchange) {
        // Redirecting the client to another URL
        exchange.getResponse().setStatusCode(HttpStatus.FOUND); // 302 Found
        exchange.getResponse().getHeaders().setLocation(URI.create("http://new-url.com"));

        return "Redirecting..."; // Response will be overridden by redirect
    }
}

package com.example.apigateway.config;

import org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for the root (fallback or static content)
                .route("root-route", r -> r.path("/")
                        .uri("http://localhost:8080")  // Or simply redirect or serve static content
                )
                // Route for WedstrijdService with RewritePath filter
                .route("wedstrijd-service", r -> r.path("/wedstrijden", "/wedstrijden/**")  // Matches both "/wedstrijden" and "/wedstrijden/some-path"
                        .filters(f -> f.rewritePath("/wedstrijden/", "/wedstrijden")) // Remove trailing slash if present
                        .uri("http://localhost:8083"))
                // Route for TeamService with RewritePath filter
                .route("team-service", r -> r.path("/teams", "/teams/**")  // Matches both "/teams" and "/teams/some-path"
                        .filters(f -> f.rewritePath("/teams/", "/teams")) // Remove trailing slash if present
                        .uri("http://localhost:8082"))
                // Route for LedenService with RewritePath filter
                .route("leden-service", r -> r.path("/leden", "/leden/**")  // Matches both "/leden" and "/leden/some-path"
                        .filters(f -> f.rewritePath("/leden/", "/leden")) // Remove trailing slash if present
                        .uri("http://localhost:8081"))
                .build();
    }
}

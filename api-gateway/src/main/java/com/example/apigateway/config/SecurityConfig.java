package com.example.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        // Create the Google client registration
        ClientRegistration googleRegistration = ClientRegistration.withRegistrationId("google")
                .clientId("455174757172-263dofi9k7fj8rqv33n40qfuq7cvb9c7.apps.googleusercontent.com")
                .clientSecret("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")
                .scope("openid", "profile", "email")
                .authorizationUri("https://accounts.google.com/o/oauth2/auth")
                .tokenUri("https://oauth2.googleapis.com/token")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .redirectUri("{baseUrl}/login/oauth2/code/google")
                .userNameAttributeName("sub")
                .clientName("Google")
                .build();

        // Register the client
        return new InMemoryClientRegistrationRepository(googleRegistration);
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/error", "/logout").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .oauth2Login(oauth -> oauth
//                        .defaultSuccessUrl("/")
//                        .failureUrl("/error")
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/")
//                );
//
//        return http.build();
//    }
}

//package com.example.apigateway;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureWebTestClient
//public class ApiGatewayIntegrationTests {
//
//    @LocalServerPort
//    private int port; // Dynamisch poortnummer voor tests
//
//    private WebTestClient webTestClient; // WebTestClient voor interactie met de server
//
//    @BeforeEach
//    public void setup() {
//        // Initialiseer WebTestClient met het dynamisch verkregen poortnummer
//        webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
//    }
//
//    @Test
//    void testRootRoute() {
//        // Test de rootroute ("/"), verwacht een succesvolle respons
//        webTestClient.get().uri("/")
//                .exchange()
//                .expectStatus().isOk()  // Verwacht een 200 OK-status
//                .expectBody().isEmpty(); // Verwacht een lege body, pas aan indien nodig
//    }
//
//    @Test
//    void testWedstrijdenRoute() {
//        // Test de /wedstrijden route, die een lijst van wedstrijden moet retourneren
//        webTestClient.get().uri("/wedstrijden")
//                .exchange()
//                .expectStatus().isOk() // Verwacht een succesvolle respons
//                .expectBody() // Controleer de bodyinhoud
//                .jsonPath("$[0].team1").isEqualTo("Club Brugge") // Controleer de naam van team1
//                .jsonPath("$[0].team2").isEqualTo("Anderlecht"); // Controleer de naam van team2
//    }
//
//    @Test
//    void testTeamsRoute() {
//        // Test de /teams route, die een lijst van teams moet retourneren
//        webTestClient.get().uri("/teams")
//                .exchange()
//                .expectStatus().isOk() // Verwacht een succesvolle respons
//                .expectBody() // Controleer de bodyinhoud
//                .jsonPath("$[0].name").isEqualTo("Club Brugge") // Controleer de teamnaam
//                .jsonPath("$[0].city").isEqualTo("Brugge"); // Controleer de stad van het team
//    }
//
//    @Test
//    void testLedenRoute() {
//        // Test de /leden route, die een lijst van leden moet retourneren
//        webTestClient.get().uri("/leden")
//                .exchange()
//                .expectStatus().isOk() // Verwacht een succesvolle respons
//                .expectBody() // Controleer de bodyinhoud
//                .jsonPath("$[0].name").isEqualTo("Yari Verschaeren") // Controleer de naam van het lid
//                .jsonPath("$[0].age").isEqualTo(23); // Controleer de leeftijd van het lid
//    }
//
//    @Test
//    void testRedirectToExternalService() {
//        // Test de redirectgedrag bij toegang tot een endpoint dat extern wordt doorgestuurd
//        webTestClient.get().uri("/teams/1") // Specifieke team route als voorbeeld
//                .exchange()
//                .expectStatus().is3xxRedirection() // Verwacht een redirect status
//                .expectHeader().valueEquals("Location", "http://localhost:8082/teams/1"); // Controleer de verwachte redirect URL
//    }
//}

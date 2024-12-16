package com.example.wedstrijdservice;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WedstrijdRepository extends MongoRepository<Wedstrijd, String> {
}

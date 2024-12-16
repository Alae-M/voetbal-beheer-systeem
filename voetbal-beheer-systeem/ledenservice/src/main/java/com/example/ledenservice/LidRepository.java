package com.example.ledenservice;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LidRepository extends MongoRepository<Lid, String> {
}

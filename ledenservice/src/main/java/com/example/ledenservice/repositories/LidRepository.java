package com.example.ledenservice.repositories;

import com.example.ledenservice.models.Lid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LidRepository extends MongoRepository<Lid, String> {
    List<Lid> findByNameContaining(String name);
}

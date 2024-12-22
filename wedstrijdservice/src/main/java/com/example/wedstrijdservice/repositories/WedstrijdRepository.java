package com.example.wedstrijdservice.repositories;

import com.example.wedstrijdservice.models.Wedstrijd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WedstrijdRepository extends JpaRepository<Wedstrijd, Long> {
    List<Wedstrijd> findByLocationContaining(String location);
}

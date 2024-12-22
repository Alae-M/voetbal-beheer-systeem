package com.example.wedstrijdservice.services;

import com.example.wedstrijdservice.models.Wedstrijd;
import com.example.wedstrijdservice.repositories.WedstrijdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WedstrijdService {

    @Autowired
    private WedstrijdRepository wedstrijdRepository;

    public List<Wedstrijd> getAllWedstrijden() {
        return wedstrijdRepository.findAll();
    }

    public Wedstrijd getWedstrijdById(Long id) {
        return wedstrijdRepository.findById(id).orElse(null);
    }

    public List<Wedstrijd> searchWedstrijdenByLocation(String location) {
        return wedstrijdRepository.findByLocationContaining(location);
    }

    public Wedstrijd saveWedstrijd(Wedstrijd wedstrijd) {
        return wedstrijdRepository.save(wedstrijd);
    }

    public Wedstrijd updateWedstrijd(Long id, Wedstrijd updatedWedstrijd) {
        if (wedstrijdRepository.existsById(id)) {
            updatedWedstrijd.setId(id);
            return wedstrijdRepository.save(updatedWedstrijd);
        }
        return null;
    }

    public void deleteWedstrijd(Long id) {
        wedstrijdRepository.deleteById(id);
    }
}

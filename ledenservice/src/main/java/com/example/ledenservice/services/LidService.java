package com.example.ledenservice.services;

import com.example.ledenservice.models.Lid;
import com.example.ledenservice.repositories.LidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LidService {

    @Autowired
    private LidRepository lidRepository;

    public List<Lid> getAllLeden() {
        return lidRepository.findAll();
    }

    public Lid getLidById(String id) {
        return lidRepository.findById(id).orElse(null);
    }

    public List<Lid> searchLedenByName(String name) {
        return lidRepository.findByNameContaining(name);
    }

    public Lid saveLid(Lid lid) {
        return lidRepository.save(lid);
    }

    public Lid updateLid(String id, Lid updatedLid) {
        if (lidRepository.existsById(id)) {
            updatedLid.setId(id);
            return lidRepository.save(updatedLid);
        }
        return null;
    }

    public void deleteLid(String id) {
        lidRepository.deleteById(id);
    }
}

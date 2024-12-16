package com.example.ledenservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leden")
public class LidController {

    @Autowired
    private LidRepository lidRepository;

    // Get all members
    @GetMapping
    public List<Lid> getAllLeden() {
        return lidRepository.findAll();
    }

    // Get a specific member by ID
    @GetMapping("/{lidnummer}")
    public Lid getLidById(@PathVariable String lidnummer) {
        Optional<Lid> lid = lidRepository.findById(lidnummer);
        return lid.orElseThrow(() -> new LidNotFoundException("Lid niet gevonden"));
    }

    // Add a new member
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lid addLid(@RequestBody Lid lid) {
        return lidRepository.save(lid);
    }

    // Update an existing member by ID
    @PutMapping("/{lidnummer}")
    public Lid updateLid(@PathVariable String lidnummer, @RequestBody Lid lidDetails) {
        Lid lid = lidRepository.findById(lidnummer)
                .orElseThrow(() -> new LidNotFoundException("Lid niet gevonden"));

        lid.setNaam(lidDetails.getNaam());
        lid.setEmail(lidDetails.getEmail());
        lid.setTelefoon(lidDetails.getTelefoon());
        lid.setLidstype(lidDetails.getLidstype());

        return lidRepository.save(lid);
    }

    // Delete a member by ID
    @DeleteMapping("/{lidnummer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLid(@PathVariable String lidnummer) {
        Lid lid = lidRepository.findById(lidnummer)
                .orElseThrow(() -> new LidNotFoundException("Lid niet gevonden"));
        lidRepository.delete(lid);
    }
}

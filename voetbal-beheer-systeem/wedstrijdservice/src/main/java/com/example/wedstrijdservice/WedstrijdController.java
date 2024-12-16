package com.example.wedstrijdservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wedstrijden")
public class WedstrijdController {

    @Autowired
    private WedstrijdRepository wedstrijdRepository;

    // Get all matches
    @GetMapping
    public List<Wedstrijd> getAllWedstrijden() {
        return wedstrijdRepository.findAll();
    }

    // Get a specific match by ID
    @GetMapping("/{wedstrijdId}")
    public Wedstrijd getWedstrijdById(@PathVariable String wedstrijdId) {
        Optional<Wedstrijd> wedstrijd = wedstrijdRepository.findById(wedstrijdId);
        return wedstrijd.orElseThrow(() -> new WedstrijdNotFoundException("Match not found"));
    }

    // Add a new match
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Wedstrijd addWedstrijd(@RequestBody Wedstrijd wedstrijd) {
        return wedstrijdRepository.save(wedstrijd);
    }

    // Update an existing match by ID
    @PutMapping("/{wedstrijdId}")
    public Wedstrijd updateWedstrijd(@PathVariable String wedstrijdId, @RequestBody Wedstrijd wedstrijdDetails) {
        Wedstrijd wedstrijd = wedstrijdRepository.findById(wedstrijdId)
                .orElseThrow(() -> new WedstrijdNotFoundException("Match not found"));

        wedstrijd.setHomeTeam(wedstrijdDetails.getHomeTeam());
        wedstrijd.setAwayTeam(wedstrijdDetails.getAwayTeam());
        wedstrijd.setMatchDate(wedstrijdDetails.getMatchDate());
        wedstrijd.setLocation(wedstrijdDetails.getLocation());

        return wedstrijdRepository.save(wedstrijd);
    }

    // Delete a match by ID
    @DeleteMapping("/{wedstrijdId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWedstrijd(@PathVariable String wedstrijdId) {
        Wedstrijd wedstrijd = wedstrijdRepository.findById(wedstrijdId)
                .orElseThrow(() -> new WedstrijdNotFoundException("Match not found"));
        wedstrijdRepository.delete(wedstrijd);
    }
}

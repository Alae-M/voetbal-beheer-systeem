package com.example.wedstrijdservice.controllers;

import com.example.wedstrijdservice.models.Wedstrijd;
import com.example.wedstrijdservice.services.WedstrijdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wedstrijden")
public class WedstrijdController {

    @Autowired
    private WedstrijdService wedstrijdService;

    @GetMapping
    public List<Wedstrijd> getAllWedstrijden() {
        return wedstrijdService.getAllWedstrijden();
    }

    @GetMapping("/{id}")
    public Wedstrijd getWedstrijdById(@PathVariable Long id) {
        return wedstrijdService.getWedstrijdById(id);
    }

    @GetMapping("/search")
    public List<Wedstrijd> searchWedstrijdenByLocation(@RequestParam String location) {
        return wedstrijdService.searchWedstrijdenByLocation(location);
    }

    @PostMapping
    public Wedstrijd addWedstrijd(@RequestBody Wedstrijd wedstrijd) {
        return wedstrijdService.saveWedstrijd(wedstrijd);
    }

    @PutMapping("/{id}")
    public Wedstrijd updateWedstrijd(@PathVariable Long id, @RequestBody Wedstrijd wedstrijd) {
        return wedstrijdService.updateWedstrijd(id, wedstrijd);
    }

    @DeleteMapping("/{id}")
    public void deleteWedstrijd(@PathVariable Long id) {
        wedstrijdService.deleteWedstrijd(id);
    }
}

package com.example.ledenservice.controllers;

import com.example.ledenservice.models.Lid;
import com.example.ledenservice.services.LidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leden")
public class LidController {

    @Autowired
    private LidService lidService;



    @GetMapping
    public List<Lid> getAllLeden() {
        return lidService.getAllLeden();
    }

    @GetMapping("/{id}")
    public Lid getLidById(@PathVariable String id) {
        return lidService.getLidById(id);
    }

    @GetMapping("/search")
    public List<Lid> searchLedenByName(@RequestParam String name) {
        return lidService.searchLedenByName(name);
    }

    @PostMapping
    public Lid addLid(@RequestBody Lid lid) {
        return lidService.saveLid(lid);
    }

    @PutMapping("/{id}")
    public Lid updateLid(@PathVariable String id, @RequestBody Lid lid) {
        return lidService.updateLid(id, lid);
    }

    @DeleteMapping("/{id}")
    public void deleteLid(@PathVariable String id) {
        lidService.deleteLid(id);
    }
}

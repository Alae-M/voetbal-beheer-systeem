package com.example.teamservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    // Get all teams
    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    // Get a specific team by ID
    @GetMapping("/{teamId}")
    public Team getTeamById(@PathVariable String teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        return team.orElseThrow(() -> new TeamNotFoundException("Team not found"));
    }

    // Add a new team
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Team addTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    // Update an existing team by ID
    @PutMapping("/{teamId}")
    public Team updateTeam(@PathVariable String teamId, @RequestBody Team teamDetails) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException("Team not found"));

        team.setTeamName(teamDetails.getTeamName());
        team.setCoach(teamDetails.getCoach());
        team.setHomeStadium(teamDetails.getHomeStadium());

        return teamRepository.save(team);
    }

    // Delete a team by ID
    @DeleteMapping("/{teamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@PathVariable String teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException("Team not found"));
        teamRepository.delete(team);
    }
}

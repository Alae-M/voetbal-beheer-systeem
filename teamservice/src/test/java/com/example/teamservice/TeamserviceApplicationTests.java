package com.example.teamservice;

import com.example.teamservice.models.Team;
import com.example.teamservice.repositories.TeamRepository;
import com.example.teamservice.services.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TeamserviceApplicationTests {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    @Test
    void shouldReturnAllTeams() {
        // Arrange
        List<Team> teams = List.of(
                new Team("Club Brugge", "Brugge"),
                new Team("Anderlecht", "Brussels")
        );
        teams.get(0).setId(1L); // ID handmatig instellen
        teams.get(1).setId(2L);
        Mockito.when(teamRepository.findAll()).thenReturn(teams);

        // Act
        List<Team> result = teamService.getAllTeams();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Club Brugge", result.get(0).getName());
        Mockito.verify(teamRepository, Mockito.times(1)).findAll();
    }

    @Test
    void shouldReturnTeamById() {
        // Arrange
        Team team = new Team("Club Brugge", "Brugge");
        team.setId(1L); // ID handmatig instellen
        Mockito.when(teamRepository.findById(1L)).thenReturn(Optional.of(team));

        // Act
        Team result = teamService.getTeamById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Club Brugge", result.getName());
        Mockito.verify(teamRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    void shouldSaveTeam() {
        // Arrange
        Team team = new Team("New Team", "New City");
        Team savedTeam = new Team("New Team", "New City");
        savedTeam.setId(10L); // ID handmatig instellen
        Mockito.when(teamRepository.save(any(Team.class))).thenReturn(savedTeam);

        // Act
        Team result = teamService.saveTeam(team);

        // Assert
        assertNotNull(result);
        assertEquals(10L, result.getId());
        assertEquals("New Team", result.getName());
        Mockito.verify(teamRepository, Mockito.times(1)).save(team);
    }
}

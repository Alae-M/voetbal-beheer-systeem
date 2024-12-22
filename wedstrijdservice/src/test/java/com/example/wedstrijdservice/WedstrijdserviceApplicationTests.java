package com.example.wedstrijdservice;

import com.example.wedstrijdservice.models.Wedstrijd;
import com.example.wedstrijdservice.repositories.WedstrijdRepository;
import com.example.wedstrijdservice.services.WedstrijdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class WedstrijdserviceApplicationTests {

    @Mock
    private WedstrijdRepository wedstrijdRepository;

    @InjectMocks
    private WedstrijdService wedstrijdService;

    @Test
    void shouldReturnAllWedstrijden() {
        // Arrange
        List<Wedstrijd> wedstrijden = List.of(
                new Wedstrijd("Club Brugge", "Anderlecht", LocalDate.of(2024, 1, 15), "Jan Breydel Stadium"),
                new Wedstrijd("Union Saint-Gilloise", "Genk", LocalDate.of(2024, 1, 16), "Stade Joseph Marien")
        );
        Mockito.when(wedstrijdRepository.findAll()).thenReturn(wedstrijden);

        // Act
        List<Wedstrijd> result = wedstrijdService.getAllWedstrijden();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Club Brugge", result.get(0).getTeam1());
        Mockito.verify(wedstrijdRepository, Mockito.times(1)).findAll();
    }

    @Test
    void shouldReturnWedstrijdById() {
        // Arrange
        Wedstrijd wedstrijd = new Wedstrijd("Club Brugge", "Anderlecht", LocalDate.of(2024, 1, 15), "Jan Breydel Stadium");
        wedstrijd.setId(1L); // ID wordt apart ingesteld
        Mockito.when(wedstrijdRepository.findById(1L)).thenReturn(Optional.of(wedstrijd));

        // Act
        Wedstrijd result = wedstrijdService.getWedstrijdById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Club Brugge", result.getTeam1());
        Mockito.verify(wedstrijdRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    void shouldSaveWedstrijd() {
        // Arrange
        Wedstrijd wedstrijd = new Wedstrijd("Team X", "Team Y", LocalDate.of(2024, 1, 30), "Unknown Stadium");
        Wedstrijd savedWedstrijd = new Wedstrijd("Team X", "Team Y", LocalDate.of(2024, 1, 30), "Unknown Stadium");
        savedWedstrijd.setId(10L); // ID wordt apart ingesteld na opslaan
        Mockito.when(wedstrijdRepository.save(any(Wedstrijd.class))).thenReturn(savedWedstrijd);

        // Act
        Wedstrijd result = wedstrijdService.saveWedstrijd(wedstrijd);

        // Assert
        assertNotNull(result);
        assertEquals(10L, result.getId());
        assertEquals("Team X", result.getTeam1());
        Mockito.verify(wedstrijdRepository, Mockito.times(1)).save(wedstrijd);
    }
}

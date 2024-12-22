package com.example.ledenservice;

import com.example.ledenservice.models.Lid;
import com.example.ledenservice.repositories.LidRepository;
import com.example.ledenservice.services.LidService;
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
class LedenserviceApplicationTests {

    @Mock
    private LidRepository lidRepository;

    @InjectMocks
    private LidService lidService;

    @Test
    void shouldReturnAllLeden() {
        // Arrange
        List<Lid> leden = List.of(
                new Lid("Yari Verschaeren", 23, "yari.verschaeren@example.com"),
                new Lid("Dante Vanzeir", 25, "dante.vanzeir@example.com")
        );
        leden.get(0).setId("676531857976ee309e4eeb88"); // Handmatig ID instellen
        leden.get(1).setId("676531857976ee309e4eeb89");
        Mockito.when(lidRepository.findAll()).thenReturn(leden);

        // Act
        List<Lid> result = lidService.getAllLeden();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Yari Verschaeren", result.get(0).getName());
        Mockito.verify(lidRepository, Mockito.times(1)).findAll();
    }

    @Test
    void shouldReturnLidById() {
        // Arrange
        Lid lid = new Lid("Yari Verschaeren", 23, "yari.verschaeren@example.com");
        lid.setId("676531857976ee309e4eeb88"); // Handmatig ID instellen
        Mockito.when(lidRepository.findById("676531857976ee309e4eeb88")).thenReturn(Optional.of(lid));

        // Act
        Lid result = lidService.getLidById("676531857976ee309e4eeb88");

        // Assert
        assertNotNull(result);
        assertEquals("Yari Verschaeren", result.getName());
        Mockito.verify(lidRepository, Mockito.times(1)).findById("676531857976ee309e4eeb88");
    }

    @Test
    void shouldSaveLid() {
        // Arrange
        Lid lid = new Lid("New Player", 20, "new.player@example.com");
        Lid savedLid = new Lid("New Player", 20, "new.player@example.com");
        savedLid.setId("676531857976ee309e4eeb99"); // Handmatig ID instellen
        Mockito.when(lidRepository.save(any(Lid.class))).thenReturn(savedLid);

        // Act
        Lid result = lidService.saveLid(lid);

        // Assert
        assertNotNull(result);
        assertEquals("676531857976ee309e4eeb99", result.getId());
        assertEquals("New Player", result.getName());
        Mockito.verify(lidRepository, Mockito.times(1)).save(lid);
    }
}

package com.example.wedstrijdservice.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "wedstrijden")
public class Wedstrijd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String team1;
    private String team2;
    private LocalDate date;
    private String location;

    // Constructors
    public Wedstrijd() {}

    public Wedstrijd(String team1, String team2, LocalDate date, String location) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

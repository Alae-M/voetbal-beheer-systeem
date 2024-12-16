package com.example.wedstrijdservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "wedstrijden")
public class Wedstrijd {

    @Id
    private String wedstrijdId;
    private String homeTeam;
    private String awayTeam;
    private LocalDateTime matchDate;
    private String location;

    // Getters and setters
    public String getWedstrijdId() {
        return wedstrijdId;
    }

    public void setWedstrijdId(String wedstrijdId) {
        this.wedstrijdId = wedstrijdId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

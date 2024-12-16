package com.example.teamservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teams")
public class Team {

    @Id
    private String teamId;
    private String teamName;
    private String coach;
    private String homeStadium;

    // Getters and setters
    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getHomeStadium() {
        return homeStadium;
    }

    public void setHomeStadium(String homeStadium) {
        this.homeStadium = homeStadium;
    }
}

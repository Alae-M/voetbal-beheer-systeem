package com.example.ledenservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leden")
public class Lid {

    @Id
    private String lidnummer;
    private String naam;
    private String email;
    private String telefoon;
    private String lidstype;

    // Getters and setters
    public String getLidnummer() {
        return lidnummer;
    }

    public void setLidnummer(String lidnummer) {
        this.lidnummer = lidnummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getLidstype() {
        return lidstype;
    }

    public void setLidstype(String lidstype) {
        this.lidstype = lidstype;
    }
}

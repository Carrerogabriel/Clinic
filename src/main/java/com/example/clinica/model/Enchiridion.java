package com.example.clinica.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Enchiridion extends EntityId {

    @OneToOne
    @JoinColumn(name = "pacient_id")
    private Person pacient;

    @OneToMany(mappedBy = "enchiridion")
    private List<Query> queries;

    @Column
    private LocalDateTime hour;

    @Column
    private String history;

    @Column
    private LocalDateTime dateCreation;

    @Column
    private LocalDateTime lastUpdate;

    @Column
    private String medicalhistory;

    @Column
    private String allergies;

    @Column
    private String medications;

    @Column
    private String comments;

    public Person getPacient() {
        return pacient;
    }

    public void setPacient(Person pacient) {
        this.pacient = pacient;
    }

    public List<Query> getQueries() {
        return queries;
    }

    public void setQueries(List<Query> queries) {
        this.queries = queries;
    }

    public LocalDateTime getHour() {
        return hour;
    }

    public void setHour(LocalDateTime hour) {
        this.hour = hour;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getMedicalhistory() {
        return medicalhistory;
    }

    public void setMedicalhistory(String medicalhistory) {
        this.medicalhistory = medicalhistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Enchiridion{" +
                "pacient=" + pacient +
                ", queries=" + queries +
                ", hour=" + hour +
                ", history='" + history + '\'' +
                ", dateCreation=" + dateCreation +
                ", lastUpdate=" + lastUpdate +
                ", medicalhistory='" + medicalhistory + '\'' +
                ", allergies='" + allergies + '\'' +
                ", medications='" + medications + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}

package com.example.clinica.dtos;

import com.example.clinica.model.Enchiridion;
import com.example.clinica.model.Pacient;
import com.example.clinica.model.Person;
import com.example.clinica.model.Query;

import java.time.LocalDateTime;

public class EnchiridionDto {

    private Long id;
    private Pacient pacient;
    private Query quaries;
    private LocalDateTime hours;
    private String history;

    public EnchiridionDto(){

    }

    public EnchiridionDto(Long id, Pacient pacient, Query queries, LocalDateTime hours, String history){

        this.id = id;
        this.pacient = pacient;
        this.quaries = queries;
        this.hours = hours;
        this.history = history;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Query getQuaries() {
        return quaries;
    }

    public void setQuaries(Query quaries) {
        this.quaries = quaries;
    }

    public LocalDateTime getHours() {
        return hours;
    }

    public void setHours(LocalDateTime hours) {
        this.hours = hours;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static EnchiridionDto fromEntity(Enchiridion entity){
        return new EnchiridionDto(

                entity.getId(),
                entity.getPacient(),
                entity.getQueries().getFirst(),
                entity.getHour(),
                entity.getHistory()
        );
    }

    public Enchiridion toEntity(){

        Enchiridion entitty = new Enchiridion();

        entitty.setId(this.id);
        entitty.setPacient(this.pacient);
        entitty.setQueries(this.toEntity().getQueries());
        entitty.setHour(this.hours);
        entitty.setHistory(this.history);
        return entitty;
    }

}

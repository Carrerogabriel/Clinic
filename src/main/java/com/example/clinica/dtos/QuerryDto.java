package com.example.clinica.dtos;

import com.example.clinica.model.*;

import java.time.LocalDateTime;

public class QuerryDto {

    private LocalDateTime time;
    private Pacient pacient;
    private Medic medic;
    private Enchiridion enchiridion;
    private String reason;
    private String diagnosis;
    private String prescription;
    private String status;

    public QuerryDto(){
    }

    public QuerryDto(LocalDateTime time, Pacient pacient, Medic medic, Enchiridion enchiridion, String reason, String diagnosis, String prescription, String status){

        this.time = time;
        this.medic = medic;
        this.pacient = pacient;
        this.enchiridion = enchiridion;
        this.reason = reason;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Enchiridion getEnchiridion() {
        return enchiridion;
    }

    public void setEnchiridion(Enchiridion enchiridion) {
        this.enchiridion = enchiridion;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static QuerryDto fromEntity(Query entity){
        return  new QuerryDto(

                entity.getTime(),
                entity.getPacient(),
                entity.getMedic(),
                entity.getEnchiridion(),
                entity.getReason(),
                entity.getDiagnosis(),
                entity.getPrescription(),
                entity.getStatus()
        );
    }

    public Query toEntity(){
        Query entity = new Query();

        entity.setTime(this.time);
        entity.setMedic(this.medic);
        entity.setPacient(this.pacient);
        entity.setEnchiridion(this.enchiridion);
        entity.setReason(this.reason);
        entity.setDiagnosis(this.diagnosis);
        entity.setPrescription(this.prescription);
        entity.setStatus(this.status);
        return entity;
    }
}

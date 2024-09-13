package com.example.clinica.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Query extends EntityId{

    @Column
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name = "Medic_id")
    private Medic medic;

    @ManyToOne
    @JoinColumn(name = "enchiridion_id")
    private Enchiridion enchiridion;

    @Column
    private String reason;

    @Column
    private String diagnosis;

    @Column
    private String prescription;

    @Column
    private String status;

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

    @Override
    public String toString() {
        return "Query{" +
                "time=" + time +
                ", pacient=" + pacient +
                ", medic=" + medic +
                ", enchiridion=" + enchiridion +
                ", reason='" + reason + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescription='" + prescription + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

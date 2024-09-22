package com.example.clinica.model;

import com.example.clinica.enns.Agreement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "Pacient")
public class Pacient extends Person {

    @Column
    private Agreement agreement;

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "agreement=" + agreement +
                '}';
    }
}

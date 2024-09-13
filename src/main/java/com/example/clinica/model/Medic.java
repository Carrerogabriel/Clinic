package com.example.clinica.model;

import com.example.clinica.enns.Specialty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "Medic")
public class Medic extends Person{

    @Column
    private String crm;

    @Column
    private Specialty specialty;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "crm='" + crm + '\'' +
                ", specialty=" + specialty +
                '}';
    }
}

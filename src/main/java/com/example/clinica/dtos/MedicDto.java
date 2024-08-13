package com.example.clinica.dtos;

import com.example.clinica.enns.Specialty;
import com.example.clinica.model.Medic;

public class MedicDto {


    private Long id;
    private String name;
    private String age;
    private String cpf;
    private String rg;
    private String adress;
    private String number;
    private String crm;
    private Specialty specialty;

    public MedicDto() {

    }

    public MedicDto(Long id, String name, String age, String cpf, String rg, String adress, String number, String crm, Specialty specialty) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.rg = rg;
        this.adress = adress;
        this.number = number;
        this.crm = crm;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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

    public static MedicDto fromEntity(Medic entity) {
        return new MedicDto(

                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getCpf(),
                entity.getRg(),
                entity.getNumber(),
                entity.getAddress(),
                entity.getCrm(),
                entity.getSpecialty()
        );
    }

    public Medic toEntity() {
        Medic entity = new Medic();

        entity.setId(this.id);
        entity.setName(this.name);
        entity.setAge(this.age);
        entity.setAddress(this.adress);
        entity.setCpf(this.cpf);
        entity.setRg(this.rg);
        entity.setNumber(this.number);
        entity.setCrm(this.crm);
        entity.setSpecialty(this.specialty);
        return entity;
    }
}

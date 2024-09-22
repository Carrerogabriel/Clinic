package com.example.clinica.dtos;

import com.example.clinica.enns.Agreement;
import com.example.clinica.model.Pacient;

public class PacientDto {


    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private String number;
    private String age;
    private String address;
    private Agreement agreement;


    public PacientDto() {

    }

    public PacientDto(Long id, String name, String cpf, String rg, String number, String age, String address, Agreement agreement) {

        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.number = number;
        this.age = age;
        this.address = address;
        this.agreement = agreement;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static PacientDto fromEntity(Pacient entity) {
        return new PacientDto(
                entity.getId(),
                entity.getName(),
                entity.getCpf(),
                entity.getRg(),
                entity.getAge(),
                entity.getNumber(),
                entity.getAddress(),
                entity.getAgreement()
        );

    }

    public Pacient toEntity() {
        Pacient entity = new Pacient();
        entity.setId(this.id);
        entity.setCpf(this.cpf);
        entity.setRg(this.rg);
        entity.setAge(this.age);
        entity.setNumber(this.number);
        entity.setAddress(this.address);
        entity.setAgreement(this.agreement);
        return entity;
    }

}
package com.example.clinica.dtos;

import com.example.clinica.model.Person;

public class PersonDto {


    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private String number;
    private String age;
    private String adress;


    public PersonDto() {

    }

    public PersonDto(Long id, String name, String cpf, String rg, String number, String age, String adress) {

        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.number = number;
        this.age = age;
        this.adress = adress;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public static PersonDto fromEntity(Person entity) {
        return new PersonDto(
                entity.getId(),
                entity.getName(),
                entity.getCpf(),
                entity.getRg(),
                entity.getAge(),
                entity.getNumber(),
                entity.getAddress()
        );

    }

    public Person toEntity() {
        Person entity = new Person();
        entity.setId(this.id);
        entity.setCpf(this.cpf);
        entity.setRg(this.rg);
        entity.setAge(this.age);
        entity.setNumber(this.number);
        entity.setAddress(this.adress);
        return entity;
    }

}
package com.example.clinica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Person extends EntityId {

    @Column
    private String name;

    @Column
    private String rg;

    @Column
    private String cpf;

    @Column
    private String number;

    @Column
    private String age;

    @Column
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", number='" + number + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

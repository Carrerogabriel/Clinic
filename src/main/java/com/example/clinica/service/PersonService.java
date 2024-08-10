package com.example.clinica.service;

import com.example.clinica.dtos.PersonDto;
import com.example.clinica.exception.NotFoundException;
import com.example.clinica.model.Medic;
import com.example.clinica.model.Person;
import com.example.clinica.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repositorPerson;


    public Person save(Person entity) {
        return repositorPerson.save(entity);

    }
    public Page<PersonDto> findAll(String filter, Pageable pageable) {
        Page<Person> personPage = repositorPerson.findAll(filter, Person.class, pageable);

        if (personPage.isEmpty()){
            throw new NotFoundException("No person found");
        }

        return personPage.map(PersonDto::fromEntity);
    }

    public Person findById(Long id) {
        return repositorPerson.findById(id).orElse(null);
    }

    public Person toAlter(Long id, Person changed) {
        Optional<Person> found = repositorPerson.findById(id);
        if ((found.isPresent())) {

            Person persons = found.get();
            persons.setName(changed.getName());
            persons.setAge(changed.getAge());
            persons.setCpf(changed.getCpf());
            persons.setRg(changed.getRg());
            persons.setNumber(changed.getNumber());
            persons.setAddress(changed.getAddress());

            return repositorPerson.save(persons);

        }
        return null;
    }
    public void remove(Long id) {repositorPerson.deleteById(id);}

}


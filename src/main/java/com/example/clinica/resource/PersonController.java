package com.example.clinica.resource;


import com.example.clinica.dtos.PersonDto;
import com.example.clinica.model.Person;
import com.example.clinica.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.AbstractController;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/person")
public class PersonController  {

    @Autowired
    private PersonService servicePerson;

    @PostMapping()
    public ResponseEntity save(@RequestBody Person person){
        Person save = servicePerson.save(person);
        return ResponseEntity.created(URI.create("/person/salvar" + person.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PersonDto> person = servicePerson.findAll(filter, pageable);
        return ResponseEntity.ok(person);
    }


    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Person person = servicePerson.findById(id);
        return ResponseEntity.ok().body(person);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        servicePerson.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Person entity){
        Person chaged = servicePerson.toAlter(id, entity);
        return  ResponseEntity.ok().body(chaged);
    }

}


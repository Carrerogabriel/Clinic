package com.example.clinica.resource;

import com.example.clinica.dtos.PacientDto;
import com.example.clinica.model.Pacient;
import com.example.clinica.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/pacient")
public class PacientController {

    @Autowired
    private PacientService servicePacient;

    @PostMapping()
    public ResponseEntity save(@RequestBody Pacient pacient){
        Pacient save = servicePacient.save(pacient);
        return ResponseEntity.created(URI.create("/pacient/salvar" + pacient.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PacientDto> pacient = servicePacient.findAll(filter, pageable);
        return ResponseEntity.ok(pacient);
    }


    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Pacient pacient = servicePacient.findById(id);
        return ResponseEntity.ok().body(pacient);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        servicePacient.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Pacient entity){
        Pacient chaged = servicePacient.toAlter(id, entity);
        return  ResponseEntity.ok().body(chaged);
    }

}



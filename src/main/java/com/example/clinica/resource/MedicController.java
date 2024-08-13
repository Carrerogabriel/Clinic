package com.example.clinica.resource;

import com.example.clinica.dtos.MedicDto;
import com.example.clinica.model.Medic;
import com.example.clinica.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/api/medics")
public class MedicController {

    @Autowired
    private MedicService serviceMedic;

    @PostMapping()
    public ResponseEntity save(@RequestBody Medic medic){
        Medic save = serviceMedic.save(medic);
        return ResponseEntity.created(URI.create("/medic/save" + medic.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MedicDto> medic = serviceMedic.findAll(filter, pageable);
        return ResponseEntity.ok(medic);
    }

    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Medic medic = serviceMedic.findById(id);
        return ResponseEntity.ok().body(medic);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceMedic.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Medic entity){
        Medic chaged = serviceMedic.toAlter(id, entity);
        return  ResponseEntity.ok().body(chaged);
    }

}


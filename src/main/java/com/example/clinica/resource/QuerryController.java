package com.example.clinica.resource;

import com.example.clinica.dtos.PersonDto;
import com.example.clinica.dtos.QuerryDto;
import com.example.clinica.model.Query;
import com.example.clinica.service.QuerryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/querry")
public class QuerryController {


    @Autowired
    private QuerryService serviceQuerry;

    @PostMapping()
    public ResponseEntity save(@RequestBody Query query){
        Query save = serviceQuerry.save(query);
        return ResponseEntity.created(URI.create("/querry/salvar" + query.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(@RequestParam(required = false) String filter,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<QuerryDto> querry = serviceQuerry.findAll(filter, pageable);
        return ResponseEntity.ok(querry);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Query query = serviceQuerry.findById(id);
        return ResponseEntity.ok().body(query);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceQuerry.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Query entity){
        Query chaged = serviceQuerry.toAlter(id, entity);
        return  ResponseEntity.ok().body(chaged);
    }

}


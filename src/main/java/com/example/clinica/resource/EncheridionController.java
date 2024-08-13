package com.example.clinica.resource;

import com.example.clinica.model.Enchiridion;
import com.example.clinica.service.EnchiridionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enchiridion")
public class EncheridionController {

    @Autowired
    private EnchiridionService serviceEnchiriodion;

    @PostMapping
    public Enchiridion save(@RequestBody Enchiridion enchiridion) {
        return serviceEnchiriodion.save(enchiridion);
    }

    @GetMapping
    public List<Enchiridion> findAll() {
        return serviceEnchiriodion.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enchiridion> findById(@PathVariable Long id) {
        Optional<Enchiridion> enchiridion = serviceEnchiriodion.findById(id);
        return enchiridion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enchiridion> updateEnchiridion(@PathVariable Long id, @RequestBody Enchiridion enchiridionDetails) {
        Enchiridion updatedEnchiridion = serviceEnchiriodion.updateEnchiridion(id, enchiridionDetails);
        if (updatedEnchiridion != null) {
            return ResponseEntity.ok(updatedEnchiridion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnchiridion(@PathVariable Long id) {
        serviceEnchiriodion.deleteEnchiridion(id);
        return ResponseEntity.noContent().build();
    }
}


package com.example.clinica.service;

import com.example.clinica.model.Enchiridion;
import com.example.clinica.repository.EnchiridionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnchiridionService {


    @Autowired
    private EnchiridionRepository repositoryEnchiridion;

    public EnchiridionService(EnchiridionRepository enchiridionRepository) {
        this.repositoryEnchiridion = enchiridionRepository;
    }

    public Enchiridion createEnchiridion(Enchiridion enchiridion) {
        return repositoryEnchiridion.save(enchiridion);
    }

    public List<Enchiridion> getAllEnchiridions() {
        return repositoryEnchiridion.findAll();
    }

    public Optional<Enchiridion> getEnchiridionById(Long id) {
        return repositoryEnchiridion.findById(id);
    }

    public Enchiridion toAlter(Long id, Enchiridion changed) {
        Optional<Enchiridion> found = repositoryEnchiridion.findById(id);
        if ((found.isPresent())) {

            Enchiridion enchiridion = found.get();
            enchiridion.setQueries(changed.getQueries());
            enchiridion.setPacient(changed.getPacient());
            enchiridion.setHour(changed.getHour());
            enchiridion.setHistory(changed.getHistory());
            enchiridion.setDateCreation(changed.getDateCreation());
            enchiridion.setLastUpdate(changed.getLastUpdate());
            enchiridion.setMedicalhistory(changed.getMedicalhistory());
            enchiridion.setAllergies(changed.getAllergies());
            enchiridion.setMedications(changed.getMedications());
            enchiridion.setComments(changed.getComments());


            return repositoryEnchiridion.save(enchiridion);

        }
        return null;
    }


    public void deleteEnchiridion(Long id) {
        repositoryEnchiridion.deleteById(id);
    }

}





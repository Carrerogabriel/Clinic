package com.example.clinica.service;

import com.example.clinica.dtos.MedicDto;
import com.example.clinica.dtos.PersonDto;
import com.example.clinica.exception.NotFoundException;
import com.example.clinica.model.Medic;

import com.example.clinica.repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class MedicService {

    @Autowired
    private MedicRepository repositoryMedic;


    public Medic save(Medic entity) {
        return repositoryMedic.save(entity);
    }

    public Page<MedicDto> findAll(String filter, Pageable pageable) {
        Page<Medic> medicsPage = repositoryMedic.findAll(filter, Medic.class, pageable);

        if (medicsPage.isEmpty()){
            throw new NotFoundException("No person found");
        }

        return medicsPage.map(MedicDto::fromEntity);
    }
    public Medic findById(Long id) {
        return repositoryMedic.findById(id).orElse(null);
    }

    public Medic toAlter(Long id, Medic changed) {
        Optional<Medic> found = repositoryMedic.findById(id);
        if ((found.isPresent())) {

            Medic medics = found.get();
            medics.setName(changed.getName());
            medics.setAge(changed.getAge());
            medics.setCpf(changed.getCpf());
            medics.setRg(changed.getRg());
            medics.setCrm(changed.getCrm());
            medics.setNumber(changed.getNumber());
            medics.setAddress(changed.getAddress());

            return repositoryMedic.save(medics);
        }
        return null;
    }
    public void remove(Long id) {repositoryMedic.deleteById(id);}

}

package com.example.clinica.service;

import com.example.clinica.dtos.PacientDto;
import com.example.clinica.exception.NotFoundException;
import com.example.clinica.model.Pacient;
import com.example.clinica.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class PacientService {

    @Autowired
    private PacientRepository repositoryPacient;


    public Pacient save(Pacient entity) {
        return repositoryPacient.save(entity);

    }
    public Page<PacientDto> findAll(String filter, Pageable pageable) {
        Page<Pacient> pacientPage = repositoryPacient.findAll(filter, Pacient.class, pageable);

        if (pacientPage.isEmpty()){
            throw new NotFoundException("No person found");
        }

        return pacientPage.map(PacientDto::fromEntity);
    }

    public Pacient findById(Long id) {
        return repositoryPacient.findById(id).orElse(null);
    }

    public Pacient toAlter(Long id, Pacient changed) {
        Optional<Pacient> found = repositoryPacient.findById(id);
        if ((found.isPresent())) {

            Pacient pacient = found.get();
            pacient.setName(changed.getName());
            pacient.setAge(changed.getAge());
            pacient.setCpf(changed.getCpf());
            pacient.setRg(changed.getRg());
            pacient.setNumber(changed.getNumber());
            pacient.setAddress(changed.getAddress());
            pacient.setAgreement(changed.getAgreement());

            return repositoryPacient.save(pacient);

        }
        return null;
    }
    public void remove(Long id) {repositoryPacient.deleteById(id);}

}


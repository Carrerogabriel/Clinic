package com.example.clinica.service;


import com.example.clinica.dtos.QuerryDto;
import com.example.clinica.exception.NotFoundException;

import com.example.clinica.model.Query;
import com.example.clinica.repository.QuerryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class QuerryService {


    @Autowired
    private QuerryRepository repositoryQuerry;


    public Query save(Query entity) {
        return repositoryQuerry.save(entity);
    }
    public Page<QuerryDto> findAll(String filter, Pageable pageable) {
        Page<Query> querryPage = repositoryQuerry.findAll(filter, Query.class, pageable);

        if (querryPage.isEmpty()){
            throw new NotFoundException("No person found");
        }

        return querryPage.map(QuerryDto::fromEntity);
    }
    public Query findById(Long id) {
        return repositoryQuerry.findById(id).orElse(null);
    }

    public Query toAlter(Long id, Query changed) {
        Optional<Query> found = repositoryQuerry.findById(id);
        if ((found.isPresent())) {

            Query querys = found.get();
            querys.setMedic(changed.getMedic());
            querys.setPacient(changed.getPacient());
            querys.setTime(changed.getTime());
            querys.setReason(changed.getReason());
            querys.setDiagnosis(changed.getDiagnosis());
            querys.setPrescription(changed.getPrescription());
            querys.setStatus(changed.getStatus());


            return repositoryQuerry.save(querys);

        }
        return null;
    }
    public void remove(Long id) {repositoryQuerry.deleteById(id);}

}


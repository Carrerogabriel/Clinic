package com.example.clinica.repository;

import com.example.clinica.exception.CustomQuerydslPredicateExecutor;
import com.example.clinica.model.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicRepository extends JpaRepository<Medic, Long>, CustomQuerydslPredicateExecutor<Medic> {

}

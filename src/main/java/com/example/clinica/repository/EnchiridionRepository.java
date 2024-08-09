package com.example.clinica.repository;

import com.example.clinica.exception.CustomQuerydslPredicateExecutor;
import com.example.clinica.model.Enchiridion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnchiridionRepository extends JpaRepository<Enchiridion, Long>, CustomQuerydslPredicateExecutor<Enchiridion> {
}

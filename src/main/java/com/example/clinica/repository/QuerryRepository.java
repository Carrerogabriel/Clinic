package com.example.clinica.repository;

import com.example.clinica.exception.CustomQuerydslPredicateExecutor;
import com.example.clinica.model.Enchiridion;
import com.example.clinica.model.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuerryRepository extends JpaRepository<Query, Long>, CustomQuerydslPredicateExecutor<Query> {
}

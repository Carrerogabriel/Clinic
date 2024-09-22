

package com.example.clinica.repository;
import com.example.clinica.exception.CustomQuerydslPredicateExecutor;
import com.example.clinica.model.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long>, CustomQuerydslPredicateExecutor<Pacient> {


}

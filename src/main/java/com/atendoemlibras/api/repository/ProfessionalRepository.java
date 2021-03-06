package com.atendoemlibras.api.repository;

import com.atendoemlibras.api.domain.Professional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepository extends CrudRepository<Professional, Long> {
    List<Professional> findAll();
}

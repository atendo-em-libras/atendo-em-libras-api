package com.atendoemlibras.api.repository;

import com.atendoemlibras.api.domain.Professional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepository extends PagingAndSortingRepository<Professional, Long> {
    List<Professional> findAll();
}

package com.atendoemlibras.api.service;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.repository.ProfessionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {
    private ProfessionalRepository repository;

    public ProfessionalService(ProfessionalRepository repository) {
        this.repository = repository;
    }

    public List<Professional> getAll() {
        return repository.getAll();
    }

    public Professional getOneProfessional(int index) {
        return getAll().get(index);
    }

    public void addProfessional(Professional professional) {
        repository.addProfessional(professional);
    }

    public void deleteProfessional (int index) {
        repository.deleteProfessional(index);
    }

}

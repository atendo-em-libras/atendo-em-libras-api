package com.atendoemlibras.api.service;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.repository.ProfessionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalService {
    private ProfessionalRepository repository;

    public ProfessionalService(ProfessionalRepository repository) {
        this.repository = repository;
    }

    public List<Professional> getAll() {
        return repository.findAll();
    }

    public Optional<Professional> getOneProfessional(long index) {
        return repository.findById(index);
    }

    public void addProfessional(Professional professional) {
        repository.save(professional);
    }

    public void deleteProfessional (long index) {
        repository.deleteById(index);
    }

    public Optional<Professional> updateProfessional(long id, Professional professional) {
        if(repository.findById(id).isPresent()){
            professional.setId(id);

            repository.save(professional);

            return Optional.of(professional);
        }

        return Optional.empty();
    }
}

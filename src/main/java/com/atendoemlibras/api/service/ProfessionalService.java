package com.atendoemlibras.api.service;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.exceptions.ProfessionalNotFoundException;
import com.atendoemlibras.api.exceptions.TokenIsNotValidException;
import com.atendoemlibras.api.repository.ProfessionalRepository;
import com.atendoemlibras.api.utils.TokenValidationUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalService {

    private ProfessionalRepository repository;

    private static final String PROFESSIONAL_WITH_ID_NOT_EXISTS = "Professional com id %s não existe.";

    private static final String TOKEN_IS_NOT_VALID = "Token não é válido";

    public ProfessionalService(ProfessionalRepository repository) {
        this.repository = repository;
    }

    public List<Professional> getAll() {
        return repository.findAll();
    }

    public Long addProfessional(Professional professional) {
        var response = repository.save(professional);
        return response.getId();
    }

    public void deleteProfessional (long id, String token) {
        if(TokenValidationUtils.isValidToken(token)) {
            var professionalFound = getProfessionalById(id);
            repository.delete(professionalFound);
        }
    }

    public Professional updateProfessional(long id, String token, Professional professional) {
        if(TokenValidationUtils.isValidToken(token)) {
            var professionalFound = getProfessionalById(id);
            professionalFound.setId(id);

            var response = repository.save(professional);
            return response;
        }

        throw new TokenIsNotValidException(TOKEN_IS_NOT_VALID);
    }

    public Professional getProfessionalById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProfessionalNotFoundException(String.format(PROFESSIONAL_WITH_ID_NOT_EXISTS, id)));
    }
}

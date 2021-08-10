package com.atendoemlibras.api.service;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.exceptions.ProfessionalNotFoundException;
import com.atendoemlibras.api.repository.ProfessionalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionalService {

    private ProfessionalRepository repository;

    private TokenValidationService tokenValidationUtils;

    private static final String PROFESSIONAL_WITH_ID_NOT_EXISTS = "Professional com id %s não existe.";

    public ProfessionalService(ProfessionalRepository repository, TokenValidationService tokenValidationUtils) {
        this.repository = repository;
        this.tokenValidationUtils = tokenValidationUtils;
    }

    public List<Professional> getAll() {
        return repository.findAll();
    }

    public Professional addProfessional(Professional professional) {
        return repository.save(professional);
    }

    public List<Professional> getProfessionalsPaginated(Integer pageNumber, Integer pageSize, String sortBy) {
        var paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

        var pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public void deleteProfessional (Long id, String token) {
        tokenValidationUtils.executeIfHasValidToken( token,
            () -> {
                var professionalFound = getProfessionalById(id);
                repository.delete(professionalFound);

                return null;
            });
    }

    public Professional updateProfessional(Long id, String token, Professional professional) {
        return tokenValidationUtils.executeIfHasValidToken(token,
            () -> {
                var foundProfessional = getProfessionalById(id);

                professional.setId(foundProfessional.getId());

                var response = repository.save(professional);
                return response;
            });
    }

    public Professional getProfessionalById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProfessionalNotFoundException(String.format(PROFESSIONAL_WITH_ID_NOT_EXISTS, id)));
    }
}

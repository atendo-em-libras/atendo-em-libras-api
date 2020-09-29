package com.atendoemlibras.api.controller;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {
    private ProfessionalService service;

    @Value("${spring.token.value}")
    private String profileToken;

    public ProfessionalController(ProfessionalService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    public List<Professional> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{index}")
    public Optional<Professional> getOneProfessional(@PathVariable("index") int index) {
        return service.getOneProfessional(index);
    }

    @PostMapping(path = "/")
    public void addProfessional(@RequestBody Professional professional) throws IOException {
        service.addProfessional(professional);
    }

    @DeleteMapping(path = "/{id}/{token}")
    public void deleteProfessional(@PathVariable("id") int id, @PathVariable("token") String token) {
        if(token.equals(profileToken)){
            service.deleteProfessional(id);
        }
    }

    @PutMapping(path = "/{id}/{token}")
    public Optional<Professional> updateProfessional(@PathVariable("id") int id, @PathVariable("token") String token, @RequestBody Professional professional){
        if(token.equals(profileToken)){
            return service.updateProfessional(id, professional);
        }
        return Optional.empty();
    }
}

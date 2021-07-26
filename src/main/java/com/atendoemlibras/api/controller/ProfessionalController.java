package com.atendoemlibras.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.service.ProfessionalService;

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
    public ResponseEntity<List<Professional>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Professional> getOneProfessional(@PathVariable Long id) {
        var response = service.getProfessionalById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Long> addProfessional(@RequestBody Professional professional, UriComponentsBuilder uriBuilder) {
        var idProfessional = service.addProfessional(professional);

        var uri = uriBuilder.path("/professionals/{id}").buildAndExpand(idProfessional).toUri();

        return ResponseEntity.created(uri).body(idProfessional);
    }

    @DeleteMapping(path = "/{id}/{token}")
    public ResponseEntity<Void> deleteProfessional(@PathVariable("id") int id, @PathVariable("token") String token) {
        service.deleteProfessional(id, token);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}/{token}")
    public ResponseEntity<Professional> updateProfessional(@PathVariable("id") int id,
                                                           @PathVariable("token") String token,
                                                           @RequestBody Professional professional){

        var response = service.updateProfessional(id, token, professional);
        return ResponseEntity.ok(response);
    }
}

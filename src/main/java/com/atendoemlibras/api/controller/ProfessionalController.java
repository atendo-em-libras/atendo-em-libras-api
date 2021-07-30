package com.atendoemlibras.api.controller;

import java.util.List;

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

import javax.validation.Valid;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {
    private ProfessionalService service;

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
    public ResponseEntity<Professional> addProfessional(@Valid @RequestBody Professional professional, UriComponentsBuilder uriBuilder) {
        var response = service.addProfessional(professional);

        var uri = uriBuilder.path("/professionals/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping(path = "/{id}/{token}")
    public ResponseEntity<Void> deleteProfessional(@PathVariable Long id, @PathVariable String token) {
        service.deleteProfessional(id, token);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}/{token}")
    public ResponseEntity<Professional> updateProfessional(@PathVariable Long id,
                                                           @PathVariable String token,
                                                           @Valid @RequestBody Professional professional){

        var response = service.updateProfessional(id, token, professional);
        return ResponseEntity.ok(response);
    }
}

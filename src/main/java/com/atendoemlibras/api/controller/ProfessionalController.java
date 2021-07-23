package com.atendoemlibras.api.controller;

import com.atendoemlibras.api.domain.Professional;
import com.atendoemlibras.api.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
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
    public ResponseEntity<List<Professional>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(path = "/{index}")
    public ResponseEntity<Professional> getOneProfessional(@PathVariable("index") int index) {
        var response = service.getOneProfessional(index);

        if(response.isPresent()){
            return ResponseEntity.ok(response.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/")
    public ResponseEntity<Long> addProfessional(@RequestBody Professional professional, UriComponentsBuilder uriBuilder) {
        var idProfessional = service.addProfessional(professional);

        var uri = uriBuilder.path("/professionals/{id}").buildAndExpand(idProfessional).toUri();

        return ResponseEntity.created(uri).body(idProfessional);
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

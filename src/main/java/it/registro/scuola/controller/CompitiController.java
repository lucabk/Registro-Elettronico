package it.registro.scuola.controller;

import it.registro.scuola.dto.CompitiDTO;
import it.registro.scuola.service.impl.CompitiServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/compiti")
public class CompitiController {

    private final CompitiServiceImpl compitiService;

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC', 'STU')")
    @GetMapping("{id}")
    public ResponseEntity<CompitiDTO> getCompito(@PathVariable("id") int idCompito){
        return ResponseEntity.ok(compitiService.getCompito(idCompito));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC', 'STU')")
    @GetMapping
    public ResponseEntity<List<CompitiDTO>> getCompitiByClasse(@RequestParam(required = true) Integer idClasse){
        return ResponseEntity.ok(compitiService.getCompitiByClasse(idClasse));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @PostMapping
    public ResponseEntity<CompitiDTO> addCompiti(@Valid @RequestBody CompitiDTO c){
        return ResponseEntity.status(HttpStatus.CREATED).body(compitiService.addCompiti(c));
    }
}

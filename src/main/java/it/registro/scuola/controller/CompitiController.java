package it.registro.scuola.controller;

import it.registro.scuola.dto.compiti.CompitiDTO;
import it.registro.scuola.dto.compiti.CompitoUpdateDTO;
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
        return ResponseEntity.ok(compitiService.getCompitoDTO(idCompito));
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

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @PutMapping("{id}")
    public ResponseEntity<CompitiDTO> updateCompiti(@Valid @RequestBody CompitoUpdateDTO c, @PathVariable("id") int idCompiti){
        return ResponseEntity.ok(compitiService.updateCompiti(c, idCompiti));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCompiti(@PathVariable("id") int idCompiti) {
        compitiService.deleteCompiti(idCompiti);
        return ResponseEntity.noContent().build();
    }
}

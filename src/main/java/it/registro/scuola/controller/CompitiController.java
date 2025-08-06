package it.registro.scuola.controller;

import it.registro.scuola.dto.CompitiDTO;
import it.registro.scuola.service.impl.CompitiServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

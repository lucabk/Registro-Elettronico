package it.registro.scuola.controller;

import it.registro.scuola.dto.incarico.IncaricoDTO;
import it.registro.scuola.service.impl.IncaricoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/incarico")
@AllArgsConstructor
public class IncaricoController {

    private final IncaricoServiceImpl incaricoService;

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @GetMapping("{id}")
    ResponseEntity<IncaricoDTO> getIncarico(@PathVariable("id") int id){
        return ResponseEntity.ok(incaricoService.getIncarico(id));
    }
}

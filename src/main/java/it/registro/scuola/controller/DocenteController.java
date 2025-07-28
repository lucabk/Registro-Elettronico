package it.registro.scuola.controller;

import it.registro.scuola.dto.docente.DocenteDTO;
import it.registro.scuola.service.impl.DocenteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/docente")
public class DocenteController {

    private DocenteServiceImpl docenteService;

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @GetMapping("{id}")
    ResponseEntity<DocenteDTO> getDocente(@PathVariable("id") int id) {
        return ResponseEntity.ok(docenteService.getDocente(id));
    }
}

package it.registro.scuola.controller;

import it.registro.scuola.dto.docente.AddDocenteDTO;
import it.registro.scuola.dto.docente.DocenteDTO;
import it.registro.scuola.service.impl.DocenteServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    //get docente by scuola

    @PreAuthorize("hasAnyRole('GES', 'SEG')")
    @PostMapping
    public ResponseEntity<DocenteDTO> addDocente(@Valid @RequestBody AddDocenteDTO d){
        return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.addDocente(d));
    }

}

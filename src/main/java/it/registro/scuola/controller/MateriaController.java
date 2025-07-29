package it.registro.scuola.controller;

import it.registro.scuola.dto.MateriaDTO;
import it.registro.scuola.mapper.MateriaMapper;
import it.registro.scuola.service.impl.MateriaServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/materia")
public class MateriaController {

    private MateriaServiceImpl materiaService;

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC', 'STU')")
    @GetMapping("{id}")
    ResponseEntity<MateriaDTO> getMateria(@PathVariable("id") int id){
        return ResponseEntity.ok(materiaService.getMateria(id));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG')")
    @PostMapping
    public ResponseEntity<MateriaDTO> addMateria(@Valid @RequestBody MateriaDTO m){
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaService.addMateria(m));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @PutMapping("{id}")
    public ResponseEntity<MateriaDTO> updateMateria(@Valid @RequestBody MateriaDTO m, @PathVariable("id") int id){
        return ResponseEntity.ok(materiaService.updateMateria(m, id));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable("id") int id){
        materiaService.deleteMateria(id);
        return ResponseEntity.noContent().build();
    }
}

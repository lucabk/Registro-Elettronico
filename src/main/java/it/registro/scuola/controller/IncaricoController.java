package it.registro.scuola.controller;

import it.registro.scuola.dto.incarico.IncaricoDTO;
import it.registro.scuola.service.impl.IncaricoServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @GetMapping("/scuola")
    ResponseEntity<List<IncaricoDTO>> getIncaricoByScuola(@RequestParam(required = true) Integer idScuola){
       return ResponseEntity.ok(incaricoService.getIncaricoByScuola(idScuola));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @GetMapping("/classe")
    ResponseEntity<List<IncaricoDTO>> getIncaricoByClasse(@RequestParam(required = true) Integer idClasse){
        return ResponseEntity.ok(incaricoService.getIncaricoByClasse(idClasse));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @GetMapping("/docente")
    ResponseEntity<List<IncaricoDTO>> getIncaricoByDocente(@RequestParam(required = true) Integer idDocente){
        return ResponseEntity.ok(incaricoService.getIncaricoByDocente(idDocente));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG')")
    @PostMapping
    ResponseEntity<IncaricoDTO> addIncarico(@Valid @RequestBody IncaricoDTO i){
        return ResponseEntity.status(HttpStatus.CREATED).body(incaricoService.addIncarico(i));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @PutMapping("{id}")
    ResponseEntity<IncaricoDTO> updateIncarico(@Valid @RequestBody IncaricoDTO i, @PathVariable int id){
        return ResponseEntity.ok(incaricoService.updateIncarico(i, id));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteIncatico(@PathVariable("id") int id){
        incaricoService.deleteIncarico(id);
        return ResponseEntity.noContent().build();
    }
}

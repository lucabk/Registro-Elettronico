package it.registro.scuola.controller;

import it.registro.scuola.dto.assenza.AssenzaDTO;
import it.registro.scuola.service.impl.AssenzaServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assenza")
@AllArgsConstructor
public class AssenzaController {
    private final AssenzaServiceImpl assenzaService;

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC', 'STU')")
    @GetMapping("{id}")
    public ResponseEntity<List<AssenzaDTO>> getAssenzeByStudente(@PathVariable("id") int idStudente){
        return ResponseEntity.ok(assenzaService.getAssenzeByStudente(idStudente));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @PostMapping
    public ResponseEntity<AssenzaDTO> addAssenza(@RequestBody @Valid AssenzaDTO a){
        return ResponseEntity.status(HttpStatus.CREATED).body(assenzaService.addAssenza(a));
    }
}

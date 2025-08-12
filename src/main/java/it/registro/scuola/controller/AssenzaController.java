package it.registro.scuola.controller;

import it.registro.scuola.dto.assenza.AssenzaDTO;
import it.registro.scuola.service.impl.AssenzaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

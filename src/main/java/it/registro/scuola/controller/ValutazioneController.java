package it.registro.scuola.controller;

import it.registro.scuola.dto.valutazione.ValutazioneDTO;
import it.registro.scuola.service.impl.ValutazioneServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/valutazione")
public class ValutazioneController {

    private final ValutazioneServiceImpl valutazioneService;

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @GetMapping("{id}")
    public ResponseEntity<ValutazioneDTO> getValutazione(@PathVariable("id") int idValutazione){
        return ResponseEntity.ok(valutazioneService.getValutazioneByIdDTO(idValutazione));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @GetMapping("/classe/{id}")
    public ResponseEntity<List<ValutazioneDTO>> getValutazioniByClasse(@PathVariable("id") int idClasse){
        return ResponseEntity.ok(valutazioneService.getValutazioniByClasseDTO(idClasse));
    }
}

package it.registro.scuola.controller;

import it.registro.scuola.dto.valutazione.ValutazioneDTO;
import it.registro.scuola.service.impl.ValutazioneServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC', 'STU')")
    @GetMapping
    public ResponseEntity<List<ValutazioneDTO>> getValutazioneByStudente(@RequestParam(required = false) int idStudente){
        return ResponseEntity.ok(valutazioneService.getValutazioniByStudenteDTO(idStudente));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @PostMapping
    public ResponseEntity<ValutazioneDTO> addValutazione(@RequestBody @Valid ValutazioneDTO v){
        return ResponseEntity.status(HttpStatus.CREATED).body(valutazioneService.addValutazione(v));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @PutMapping("{id}")
    public ResponseEntity<ValutazioneDTO> updateValutazione(@RequestBody @Valid ValutazioneDTO v, @PathVariable("id") int idValutazione){
        return ResponseEntity.ok(valutazioneService.updateValutazione(v, idValutazione));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteValutazione(@PathVariable int id){
        valutazioneService.deleteValutazione(id);
        return ResponseEntity.noContent().build();
    }
}

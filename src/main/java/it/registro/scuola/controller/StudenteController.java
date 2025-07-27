package it.registro.scuola.controller;

import it.registro.scuola.dto.Studente.AddStudenteDTO;
import it.registro.scuola.dto.Studente.StudenteDTO;
import it.registro.scuola.service.impl.StudenteServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/studente")
public class StudenteController {

    private StudenteServiceImpl studenteService;

    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('GES', 'SEG', 'STU')")
    public ResponseEntity<StudenteDTO> getStudente(@PathVariable("id") int id) {
        return ResponseEntity.ok(studenteService.getStudente(id));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG')")
    @GetMapping
    public ResponseEntity<List<StudenteDTO>> getStudentiByScuola(@RequestParam(required = true) Integer idScuola) {
        return ResponseEntity.ok(studenteService.getStudentiByScuola(idScuola));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG')")
    @PostMapping
    public ResponseEntity<StudenteDTO> addStudente(@Valid @RequestBody AddStudenteDTO s) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studenteService.addStudente(s));
    }

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'STU')")
    @PutMapping("{id}")
    public ResponseEntity<StudenteDTO> updateStudente(@Valid @RequestBody StudenteDTO s, @PathVariable("id") int id) {
        return ResponseEntity.ok(studenteService.updateStudente(s, id));
    }
}

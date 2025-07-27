package it.registro.scuola.controller;

import it.registro.scuola.dto.StudenteDTO;
import it.registro.scuola.service.impl.StudenteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

}

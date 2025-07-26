package it.registro.scuola.controller;

import it.registro.scuola.dto.StudenteDTO;
import it.registro.scuola.service.impl.StudenteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@PreAuthorize("hasAnyRole('GES', 'SEG')")
@RequestMapping("/api/studente")
public class StudenteController {

    private StudenteServiceImpl studenteService;

    @GetMapping("{id}")
    public ResponseEntity<StudenteDTO> getStudente(@PathVariable("id") int id) {
        return ResponseEntity.ok(studenteService.getStudente(id));
    }
}

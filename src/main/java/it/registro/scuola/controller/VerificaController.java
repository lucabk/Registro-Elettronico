package it.registro.scuola.controller;

import it.registro.scuola.dto.verifica.VerificaDTO;
import it.registro.scuola.service.impl.VerificaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/verifica")
public class VerificaController {

    private final VerificaServiceImpl verificaService;

    @PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC', 'STU')")
    @GetMapping("{id}")
    public ResponseEntity<VerificaDTO> getVerifica(@PathVariable int id){
        return ResponseEntity.ok(verificaService.getVerificaDTO(id));
    }
}

package it.registro.scuola.controller;

import it.registro.scuola.dto.TokenDTO;
import it.registro.scuola.dto.UtenteDTO;
import it.registro.scuola.model.Utente;
import it.registro.scuola.service.impl.UtenteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/login")
public class UtenteController {
    private UtenteServiceImpl utenteService;

    @PostMapping
    public ResponseEntity<TokenDTO> login(@RequestBody UtenteDTO utente) throws Exception {
        return ResponseEntity.ok(utenteService.verify(utente));
    }
}

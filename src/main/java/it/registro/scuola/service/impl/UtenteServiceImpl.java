package it.registro.scuola.service.impl;

import it.registro.scuola.model.Utente;
import it.registro.scuola.repository.UtenteRepository;
import it.registro.scuola.service.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UtenteServiceImpl implements UtenteService {

    private UtenteRepository utenteRepository;

    @Override
    public Utente addUtente(Utente u) {
        if(utenteRepository.findByUsername(u.getUsername()) != null) {
            throw new IllegalArgumentException("Utente con username '" + u.getUsername() + "' già presente nel db");
        }
        return utenteRepository.save(u);
    }
}

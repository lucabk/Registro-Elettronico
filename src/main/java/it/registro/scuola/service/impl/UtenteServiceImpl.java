package it.registro.scuola.service.impl;

import it.registro.scuola.model.Utente;
import it.registro.scuola.repository.UtenteRepository;
import it.registro.scuola.service.UtenteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UtenteServiceImpl implements UtenteService {

    private UtenteRepository utenteRepository;
    private BCryptPasswordEncoder encoder;

    @Override
    public Utente addUtente(Utente u) {
        if(utenteRepository.findByUsername(u.getUsername()) != null) {
            throw new IllegalArgumentException("Utente con username '" + u.getUsername() + "' già presente nel db");
        }
        u.setPassword(encoder.encode(u.getPassword()));
        return utenteRepository.save(u);
    }

    @Override
    public void upUtenteSegreteria(int riferimentoId, String newPasssword) {
        Utente utenteToUp = utenteRepository.findByRiferimentoId(riferimentoId);
        if(utenteToUp == null){
            throw new EntityNotFoundException("Utente con riferimento id "+riferimentoId+ " non trovato");
        }
        utenteToUp.setPassword(encoder.encode(newPasssword));
    }
}

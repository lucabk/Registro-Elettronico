package it.registro.scuola.service.impl;

import it.registro.scuola.dto.utente.UpdateUtentePswDTO;
import it.registro.scuola.dto.TokenDTO;
import it.registro.scuola.dto.utente.UtenteDTO;
import it.registro.scuola.model.Utente;
import it.registro.scuola.repository.UtenteRepository;
import it.registro.scuola.service.UtenteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UtenteServiceImpl implements UtenteService {

    private UtenteRepository utenteRepository;
    private BCryptPasswordEncoder encoder;
    private AuthenticationManager authenticationManager;
    private JWTServiceImpl jwtService;

    @Override
    public Utente addUtente(Utente u) {
        if(utenteRepository.findByUsername(u.getUsername()) != null) {
            throw new IllegalArgumentException("Utente con username '" + u.getUsername() + "' già presente nel db");
        }
        u.setPassword(encoder.encode(u.getPassword()));
        return utenteRepository.save(u);
    }

    @Override
    public void upUtentePsw(int riferimentoId, UpdateUtentePswDTO credentials) {
        Utente utenteToUp = utenteRepository.findByRiferimentoId(riferimentoId);
        if(utenteToUp == null){
            throw new EntityNotFoundException("Utente con riferimento id "+riferimentoId+ " non trovato");
        }
        if(utenteToUp.getUsername().equals(credentials.getUsername())){
            utenteToUp.setPassword(encoder.encode(credentials.getPassword()));
        } else {
            throw new IllegalArgumentException("Username invalido");
        }
    }

    @Override
    public void deleteUtente(int idRiferimento) {
        Utente u = utenteRepository.findByRiferimentoId(idRiferimento);
        if(u != null){
            utenteRepository.deleteById(u.getId());
        }
    }

    @Override //login
    public TokenDTO verify(UtenteDTO utente) {
        if(utente.getUsername().charAt(0) != 'G' && utente.getUsername().charAt(0) != 'S' && utente.getUsername().charAt(0) != 'D' && utente.getUsername().charAt(0) != 'A'){
            throw new BadCredentialsException("Lo username deve iniziare con A, S, D o G seguito da una serie di numeri");
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(utente.getUsername(), utente.getPassword())
        );
        if(authentication.isAuthenticated()) {
            return new TokenDTO(jwtService.generateToken(utente.getUsername()));
        } else {
            throw  new BadCredentialsException("Credenziali non valide");
        }

    }
}

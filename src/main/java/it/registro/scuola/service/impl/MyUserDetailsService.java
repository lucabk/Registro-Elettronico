package it.registro.scuola.service.impl;

import it.registro.scuola.model.UserPrincipal;
import it.registro.scuola.model.Utente;
import it.registro.scuola.repository.UtenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private UtenteRepository utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Utente utente = utenteRepository.findByUsername(username);
        if(utente == null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("Utente '"+ username + "' non trovato");
        }

        return new UserPrincipal(utente);
    }
}

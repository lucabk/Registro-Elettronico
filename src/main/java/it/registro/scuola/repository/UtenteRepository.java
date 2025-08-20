package it.registro.scuola.repository;

import it.registro.scuola.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
    Utente findByUsername(String username);
    Utente findByRiferimentoIdAndRuolo(int id, String ruolo);
}

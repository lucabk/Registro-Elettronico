package it.registro.scuola.service;

import it.registro.scuola.dto.TokenDTO;
import it.registro.scuola.dto.UtenteDTO;
import it.registro.scuola.model.Utente;

public interface UtenteService {
    Utente addUtente(Utente u);

    void upUtenteSegreteria(int idRiferimento, String password);

    void deleteUtente(int idRiferimento);

    TokenDTO verify(UtenteDTO utente);
}

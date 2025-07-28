package it.registro.scuola.service;

import it.registro.scuola.dto.utente.UpdateUtentePswDTO;
import it.registro.scuola.dto.TokenDTO;
import it.registro.scuola.dto.utente.UtenteDTO;
import it.registro.scuola.model.Utente;

public interface UtenteService {
    Utente addUtente(Utente u);

    void upUtentePsw(int idRiferimento, UpdateUtentePswDTO credentials);

    void deleteUtente(int idRiferimento);

    TokenDTO verify(UtenteDTO utente);
}

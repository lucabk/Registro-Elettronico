package it.registro.scuola.service;

import it.registro.scuola.model.Utente;

public interface UtenteService {
    Utente addUtente(Utente u);
    void upUtenteSegreteria(int idRiferimento, String password);
}

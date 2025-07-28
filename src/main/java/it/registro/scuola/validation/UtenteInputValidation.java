package it.registro.scuola.validation;

import it.registro.scuola.dto.utente.UpdateUtentePswDTO;

public class UtenteInputValidation {
    public static void ValidationUpdateUtentePswDTO(UpdateUtentePswDTO req) {
        if (req.getUsername() == null || req.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare uno username");
        } else if (req.getPassword() == null || req.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare una password");
        }
    }
}

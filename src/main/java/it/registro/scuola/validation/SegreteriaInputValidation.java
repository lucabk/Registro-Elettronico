package it.registro.scuola.validation;

import it.registro.scuola.dto.segreteria.AddSegreteriaReqDTO;

public class SegreteriaInputValidation {

    //POST validation
    public static void addSegreteriaReqDTOValidation(AddSegreteriaReqDTO req) {
        if(req.getScuolaDTO() == null || req.getScuolaDTO().getId() <= 0) {
            throw new IllegalArgumentException("E' obbliglatorio specificare la scuola a cui aggiungere la segreteria");
        } else if (req.getNome() == null || req.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare un nome interno per la segreteria");
        } else if (req.getUsername() == null || req.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare uno username per l'utente assocaito alla segreteria");
        } else if (req.getPassword() == null || req.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare una password per l'utente assocaito alla segreteria");
        } else if (req.getUsername().charAt(0) != 'S') {
            throw new IllegalArgumentException("Lo username della segreteria deve iniziare con la 'S' maiuscola");
        }
    }


}

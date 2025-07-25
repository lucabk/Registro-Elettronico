package it.registro.scuola.validation;

import it.registro.scuola.dto.segreteria.AddSegreteriaReqDTO;
import it.registro.scuola.dto.segreteria.UpSegreteriaPswDTO;

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
        }
    }

    //PUT psw validation
    public static void upSegreteriaPswDTOValidation(UpSegreteriaPswDTO req) {
        if(req.getPassword() == null) {
            throw new IllegalArgumentException("E' obbliglatorio specificare la nuova password");
        }
    }
}

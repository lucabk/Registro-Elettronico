package it.registro.scuola.validation;

import it.registro.scuola.dto.Studente.AddStudenteDTO;
import it.registro.scuola.dto.Studente.StudenteDTO;
import it.registro.scuola.dto.Studente.UpdatePswStudenteDTO;

public class StudenteInputValidation {
    public static void ValidationAddStudenteDTO(AddStudenteDTO req) {
        if(req.getScuolaDTO() == null || req.getScuolaDTO().getId() <= 0) {
            throw new IllegalArgumentException("E' obbliglatorio specificare la scuola a cui aggiungere lo studente");
        } else if(req.getClasseDTO() == null || req.getClasseDTO().getId() <= 0) {
            throw new IllegalArgumentException("E' obbliglatorio specificare la classe a cui aggiungere lo studente");
        } else if (req.getUsername() == null || req.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare uno username");
        } else if (req.getPassword() == null || req.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare una password");
        } else if(req.getUsername().charAt(0) != 'A') {
            throw new IllegalArgumentException("Lo username dello studente deve iniziare con un 'A' maiuscola seguita dal numero di matricola");
        }
    }

    public static void ValidationStudenteDTO(StudenteDTO req) {
        if(req.getScuolaDTO() == null || req.getScuolaDTO().getId() <= 0) {
            throw new IllegalArgumentException("E' obbliglatorio specificare la scuola a cui aggiungere lo studente");
        } else if(req.getClasseDTO() == null || req.getClasseDTO().getId() <= 0) {
            throw new IllegalArgumentException("E' obbliglatorio specificare la classe a cui aggiungere lo studente");
        }
    }

    public static void ValidationupdatePswStudenteDTO(UpdatePswStudenteDTO req) {
        if (req.getUsername() == null || req.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare uno username");
        } else if (req.getPassword() == null || req.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare una password");
        }
    }
}

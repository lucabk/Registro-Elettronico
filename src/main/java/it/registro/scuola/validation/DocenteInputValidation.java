package it.registro.scuola.validation;

import it.registro.scuola.dto.docente.AddDocenteDTO;

public class DocenteInputValidation {
    public static void validationAddDocenteDTO(AddDocenteDTO req){
        if (req.getUsername() == null || req.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare uno username");
        } else if (req.getPassword() == null || req.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("E' obbligatorio specificare una password");
        }  else if(req.getUsername().charAt(0) != 'D') {
        throw new IllegalArgumentException("Lo username del docente deve iniziare con un 'D' maiuscola seguita dal numero di matricola");
    }
    }
}

package it.registro.scuola.validation;

import it.registro.scuola.dto.incarico.IncaricoDTO;
import it.registro.scuola.model.Classe;
import it.registro.scuola.model.Scuola;

public class IncaricoInputValidation {
    public static void addIncaricoDTOValidation(IncaricoDTO req){
        if(req.getScuolaDTO() == null || req.getScuolaDTO().getId() < 0){
            throw new IllegalArgumentException("E' obbligatorio inserire una scuola valida per l'incarico");
        } else if (req.getClasseDTO() == null || req.getClasseDTO().getId() < 0) {
            throw new IllegalArgumentException("E' obbligatorio inserire una classe valida per l'incarico");
        } else if (req.getDocenteDTO() == null || req.getDocenteDTO().getId() < 0) {
            throw new IllegalArgumentException("E' obbligatorio inserire un deocente valido per l'incarico");
        } else if (req.getMateriaDTO() == null || req.getMateriaDTO().getId() < 0) {
            throw new IllegalArgumentException("E' obbligatorio inserire una materia valida per l'incarico");
        }
    }

    public static void checkScuolaClasse(Scuola s, Classe c) {
        if(c.getScuola().getId() != s.getId()){
            throw new IllegalArgumentException("La classe a cui aggiungere l'incarico non appartiene alla scuola specificata");
        }
    }
}

package it.registro.scuola.mapper;

import it.registro.scuola.dto.StudenteDTO;
import it.registro.scuola.model.Studente;

public class StudenteMapper {
    public static StudenteDTO toDTO(Studente s){
        return new StudenteDTO(s.getId(), s.getNome(), s.getCognome(), s.getEmail(), s.getNumero(),
                s.getCodiceFiscale(), s.getIndirizzo(), s.getCitta(), s.getProvincia(), s.getCap(),
                ScuolaMapper.toDTO(s.getScuola()), ClasseMapper.toDTO(s.getClasse()));
    }

}

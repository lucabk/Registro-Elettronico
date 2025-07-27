package it.registro.scuola.mapper;

import it.registro.scuola.dto.StudenteDTO;
import it.registro.scuola.model.Studente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudenteMapper {
    public static StudenteDTO toDTO(Studente s){
        return new StudenteDTO(s.getId(), s.getNome(), s.getCognome(), s.getEmail(), s.getNumero(),
                s.getCodiceFiscale(), s.getIndirizzo(), s.getCitta(), s.getProvincia(), s.getCap(),
                ScuolaMapper.toDTO(s.getScuola()), ClasseMapper.toDTO(s.getClasse()));
    }

    public static List<StudenteDTO> toListDTO(List<Studente> studentes) {
        return studentes.stream().map(s -> toDTO(s)).collect(Collectors.toCollection(ArrayList::new));
    }
}

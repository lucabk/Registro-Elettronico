package it.registro.scuola.mapper;

import it.registro.scuola.dto.Studente.AddStudenteDTO;
import it.registro.scuola.dto.Studente.StudenteDTO;
import it.registro.scuola.model.Classe;
import it.registro.scuola.model.Scuola;
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

    public static Studente toEntity(AddStudenteDTO s, Scuola scuolaStudente, Classe classeStudente) {
        return new Studente(s.getNome(), s.getCognome(), s.getEmail(), s.getNumero(), s.getCodiceFiscale(),
                s.getIndirizzo(), s.getCitta(), s.getProvincia(), s.getCap(), scuolaStudente, classeStudente);
    }

    public static Studente entityToUpdate(Studente originalEntity, StudenteDTO s) {
        originalEntity.setNome(s.getNome());
        originalEntity.setCognome(s.getCognome());
        originalEntity.setEmail(s.getEmail());
        originalEntity.setNumero(s.getNumero());
        originalEntity.setCodiceFiscale(s.getCodiceFiscale());
        originalEntity.setIndirizzo(s.getIndirizzo());
        originalEntity.setCitta(s.getCitta());
        originalEntity.setProvincia(s.getProvincia());
        originalEntity.setCap(s.getCap());
        return originalEntity;
    }
}

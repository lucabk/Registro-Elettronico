package it.registro.scuola.mapper;

import it.registro.scuola.dto.assenza.AssenzaDTO;
import it.registro.scuola.model.Assenza;
import it.registro.scuola.model.Studente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssenzaMapper {
    public static AssenzaDTO toDTO(Assenza a){
        return new AssenzaDTO(a.getId(), a.isGiustificata(), a.getTipo(), StudenteMapper.toDTO(a.getStudente()));
    }

    public static List<AssenzaDTO> toListDTO(List<Assenza> a) {
        return a.stream().map(AssenzaMapper::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    public static Assenza toEntity(AssenzaDTO a, Studente studenteModel) {
        Assenza entity = new Assenza(false, a.getTipo());
        entity.setStudente(studenteModel);
        return entity;
    }

    public static Assenza toEnityUp(AssenzaDTO a, Assenza originalEntity) {
        originalEntity.setGiustificata(a.getGiustificata());
        return originalEntity;
    }
}

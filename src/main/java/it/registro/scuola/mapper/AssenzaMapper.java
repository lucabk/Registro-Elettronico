package it.registro.scuola.mapper;

import it.registro.scuola.dto.assenza.AssenzaDTO;
import it.registro.scuola.model.Assenza;

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
}

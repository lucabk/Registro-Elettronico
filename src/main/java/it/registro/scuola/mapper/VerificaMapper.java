package it.registro.scuola.mapper;

import it.registro.scuola.dto.verifica.VerificaDTO;
import it.registro.scuola.model.Incarico;
import it.registro.scuola.model.Verifica;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VerificaMapper {
    public static VerificaDTO toDTO(Verifica v) {
        return new VerificaDTO(v.getId(), v.getTipo(), v.getArgomenti(), v.getDataVerifica(), IncaricoMapper.toDTO(v.getIncarico()));
    }

    public static List<VerificaDTO> toListDTO(List<Verifica> v) {
        return v.stream().map(VerificaMapper::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    public static Verifica toEntity(VerificaDTO v, Incarico i) {
        Verifica entity = new Verifica(v.getTipo(), v.getDataVerifica(), v.getArgomenti());
        entity.setIncarico(i);
        return entity;
    }
}

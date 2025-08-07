package it.registro.scuola.mapper;

import it.registro.scuola.dto.verifica.VerificaDTO;
import it.registro.scuola.model.Verifica;

public class VerificaMapper {
    public static VerificaDTO toDTO(Verifica v) {
        return new VerificaDTO(v.getId(), v.getTipo(), v.getArgomenti(), v.getDataVerifica(), IncaricoMapper.toDTO(v.getIncarico()));
    }
}

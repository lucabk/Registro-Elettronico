package it.registro.scuola.mapper;

import it.registro.scuola.dto.valutazione.ValutazioneDTO;
import it.registro.scuola.model.Valutazione;

public class ValutazioneMapper {
    public static ValutazioneDTO toDTO(Valutazione v) {
        return new ValutazioneDTO(v.getId(), v.getVoto(), v.getTipo(), StudenteMapper.toDTO(v.getStudente()),
                IncaricoMapper.toDTO(v.getIncarico()));
    }
}

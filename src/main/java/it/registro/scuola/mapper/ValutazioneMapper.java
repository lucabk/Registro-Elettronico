package it.registro.scuola.mapper;

import it.registro.scuola.dto.valutazione.ValutazioneDTO;
import it.registro.scuola.model.Valutazione;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValutazioneMapper {
    public static ValutazioneDTO toDTO(Valutazione v) {
        return new ValutazioneDTO(v.getId(), v.getVoto(), v.getTipo(), StudenteMapper.toDTO(v.getStudente()),
                IncaricoMapper.toDTO(v.getIncarico()));
    }


    public static List<ValutazioneDTO> toListDTO(List<Valutazione> v) {
        return v.stream().map(ValutazioneMapper::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }
}

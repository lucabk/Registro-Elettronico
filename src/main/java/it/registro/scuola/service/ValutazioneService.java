package it.registro.scuola.service;

import it.registro.scuola.dto.valutazione.ValutazioneDTO;

public interface ValutazioneService {
    ValutazioneDTO getValutazioneByIdDTO(int id);
}

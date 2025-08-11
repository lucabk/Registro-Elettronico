package it.registro.scuola.service;

import it.registro.scuola.dto.valutazione.ValutazioneDTO;

import java.util.List;

public interface ValutazioneService {
    ValutazioneDTO getValutazioneByIdDTO(int id);
    List<ValutazioneDTO> getValutazioniByClasseDTO(int idClasse);
    List<ValutazioneDTO> getValutazioniByStudenteDTO(int idStudente);
    ValutazioneDTO addValutazione(ValutazioneDTO v);
}

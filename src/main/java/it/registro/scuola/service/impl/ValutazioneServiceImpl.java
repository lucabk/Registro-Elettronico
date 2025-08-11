package it.registro.scuola.service.impl;

import it.registro.scuola.dto.valutazione.ValutazioneDTO;
import it.registro.scuola.mapper.ValutazioneMapper;
import it.registro.scuola.repository.ValutazioneRepository;
import it.registro.scuola.service.ValutazioneService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ValutazioneServiceImpl implements ValutazioneService {

    private final ValutazioneRepository valutazioneRepository;

    @Override
    public ValutazioneDTO getValutazioneByIdDTO(int id) {
        return ValutazioneMapper.toDTO(valutazioneRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Valutazione con id "+id+" non trovata")));
    }

    @Override
    public List<ValutazioneDTO> getValutazioniByClasseDTO(int idClasse) {
        return ValutazioneMapper.toListDTO(valutazioneRepository.findValutazioneByIncarico_Classe_Id(idClasse));
    }
}

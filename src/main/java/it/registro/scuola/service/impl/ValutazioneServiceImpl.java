package it.registro.scuola.service.impl;

import it.registro.scuola.dto.valutazione.ValutazioneDTO;
import it.registro.scuola.mapper.ValutazioneMapper;
import it.registro.scuola.model.Valutazione;
import it.registro.scuola.repository.ValutazioneRepository;
import it.registro.scuola.service.ValutazioneService;
import it.registro.scuola.validation.ValutazioneValidation;
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
    private final IncaricoServiceImpl incaricoService;
    private final StudenteServiceImpl studenteService;

    @Override
    public ValutazioneDTO getValutazioneByIdDTO(int id) {
        return ValutazioneMapper.toDTO(valutazioneRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Valutazione con id "+id+" non trovata")));
    }

    public Valutazione getValutazioneById(int id) {
        return valutazioneRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Valutazione con id "+id+" non trovata"));
    }

    @Override
    public List<ValutazioneDTO> getValutazioniByClasseDTO(int idClasse) {
        return ValutazioneMapper.toListDTO(valutazioneRepository.findValutazioneByIncarico_Classe_Id(idClasse));
    }

    @Override
    public List<ValutazioneDTO> getValutazioniByStudenteDTO(int idStudente) {
        return ValutazioneMapper.toListDTO(valutazioneRepository.findValutazioneByStudente_Id(idStudente));
    }

    @Override
    public ValutazioneDTO addValutazione(ValutazioneDTO v) {
        ValutazioneValidation.addValutazioneDTOValidation(v);
        return ValutazioneMapper.toDTO(valutazioneRepository.save(ValutazioneMapper.toEntitySave(
                incaricoService.getIncaricoModel(v.getIncaricoDTO().getId()),
                studenteService.getStudenteModel(v.getStudenteDTO().getId()),
                v
        )));
    }

    @Override
    public ValutazioneDTO updateValutazione(ValutazioneDTO v, int idValutazione) {
        return ValutazioneMapper.toDTO(valutazioneRepository.save(ValutazioneMapper.toEntityUpdate(getValutazioneById(idValutazione), v)));
    }
}

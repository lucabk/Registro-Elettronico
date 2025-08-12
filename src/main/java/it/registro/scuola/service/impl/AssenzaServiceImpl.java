package it.registro.scuola.service.impl;

import it.registro.scuola.dto.assenza.AssenzaDTO;
import it.registro.scuola.mapper.AssenzaMapper;
import it.registro.scuola.model.Assenza;
import it.registro.scuola.repository.AssenzaRepository;
import it.registro.scuola.service.AssenzaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AssenzaServiceImpl implements AssenzaService {
    private final AssenzaRepository assenzaRepository;
    private final StudenteServiceImpl studenteService;

    public Assenza getAssenza(int id){
        return assenzaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Assenza con id "+id+" non trovata"));
    }

    @Override
    public List<AssenzaDTO> getAssenzeByStudente(int idStudente) {
        return AssenzaMapper.toListDTO(assenzaRepository.findAssenzasByStudente_Id(idStudente));
    }

    @Override
    public AssenzaDTO addAssenza(AssenzaDTO a) {
        if(a.getStudenteDTO() == null || a.getStudenteDTO().getId() <= 0){
            throw new IllegalArgumentException("Specificare studente da assentare");
        }
        return AssenzaMapper.toDTO(assenzaRepository.save(AssenzaMapper
                .toEntity(a, studenteService.getStudenteModel(a.getStudenteDTO().getId()))));
    }

    @Override
    public AssenzaDTO giustificaAssenza(AssenzaDTO a, int idAssenza) {
        return AssenzaMapper.toDTO(assenzaRepository.save(AssenzaMapper.toEnityUp(a,getAssenza(idAssenza))));
    }
}

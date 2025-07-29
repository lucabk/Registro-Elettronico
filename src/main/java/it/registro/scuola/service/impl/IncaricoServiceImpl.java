package it.registro.scuola.service.impl;

import it.registro.scuola.dto.incarico.IncaricoDTO;
import it.registro.scuola.mapper.IncaricoMapper;
import it.registro.scuola.repository.IncaricoRepository;
import it.registro.scuola.service.IncaricoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class IncaricoServiceImpl implements IncaricoService {

    private final IncaricoRepository incaricoRepository;

    @Override
    public IncaricoDTO getIncarico(int id) {
        return IncaricoMapper.toDTO(incaricoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Incarico con id "+id+" non trovato")));
    }

    @Override
    public List<IncaricoDTO> getIncaricoByScuola(int idScuola) {
        return IncaricoMapper.toListDTO(incaricoRepository.findByScuolaId(idScuola));
    }

    @Override
    public List<IncaricoDTO> getIncaricoByClasse(int idClasse) {
        return IncaricoMapper.toListDTO(incaricoRepository.findByClasseId(idClasse));
    }
}

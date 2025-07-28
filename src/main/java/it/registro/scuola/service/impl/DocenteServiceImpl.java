package it.registro.scuola.service.impl;

import it.registro.scuola.dto.docente.DocenteDTO;
import it.registro.scuola.mapper.DocenteMapper;
import it.registro.scuola.repository.DocenteRepository;
import it.registro.scuola.service.DocenteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DocenteServiceImpl implements DocenteService {

    private DocenteRepository docenteRepository;

    @Override
    public DocenteDTO getDocente(int id) {
        return DocenteMapper.toDTO(docenteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Docente con id "+id+" non trovato")));
    }
}

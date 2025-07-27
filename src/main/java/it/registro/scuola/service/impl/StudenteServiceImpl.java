package it.registro.scuola.service.impl;

import it.registro.scuola.dto.StudenteDTO;
import it.registro.scuola.mapper.StudenteMapper;
import it.registro.scuola.repository.StudenteRepository;
import it.registro.scuola.service.StudenteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class StudenteServiceImpl implements StudenteService {

    private StudenteRepository studenteRepository;

    @Override
    public StudenteDTO getStudente(int id) {
        return StudenteMapper.toDTO(studenteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Studente con id "+id+" non trovato")));
    }

    @Override
    public List<StudenteDTO> getStudentiByScuola(int idScuola) {
        return StudenteMapper.toListDTO(studenteRepository.findByClasseId(idScuola));
    }
}

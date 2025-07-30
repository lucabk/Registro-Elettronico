package it.registro.scuola.service.impl;

import it.registro.scuola.dto.MateriaDTO;
import it.registro.scuola.mapper.MateriaMapper;
import it.registro.scuola.model.Materia;
import it.registro.scuola.repository.MateriaRepository;
import it.registro.scuola.service.MateriaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;

    @Override
    public MateriaDTO getMateriaDTO(int id) {
        return MateriaMapper.toDTO(materiaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Matiera con id "+id+" non trovata")));
    }

    public Materia getMateria(int id){
        return materiaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Matiera con id "+id+" non trovata"));
    }

    @Override
    public MateriaDTO addMateria(MateriaDTO m) {
        return MateriaMapper.toDTO(materiaRepository.save(MateriaMapper.toEntity(m)));
    }

    @Override
    public MateriaDTO updateMateria(MateriaDTO m, int id) {
        Materia originalEntity = materiaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Materia con id "+id+" non trovata"));
        Materia entityUpdated = MateriaMapper.EntityToUpdate(originalEntity, m);
        return MateriaMapper.toDTO(materiaRepository.save(entityUpdated));
    }

    @Override
    public void deleteMateria(int id) {
        getMateriaDTO(id);
        materiaRepository.deleteById(id);
    }
}

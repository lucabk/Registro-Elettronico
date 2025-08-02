package it.registro.scuola.service.impl;

import it.registro.scuola.dto.incarico.IncaricoDTO;
import it.registro.scuola.mapper.IncaricoMapper;
import it.registro.scuola.model.*;
import it.registro.scuola.repository.IncaricoRepository;
import it.registro.scuola.service.IncaricoService;
import it.registro.scuola.validation.IncaricoInputValidation;
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
    private final ScuolaServiceImpl scuolaService;
    private final ClasseServiceImpl classeService;
    private final DocenteServiceImpl docenteService;
    private final MateriaServiceImpl materiaService;

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

    @Override
    public IncaricoDTO addIncarico(IncaricoDTO i) {
        Dati dati = getDati(i);
        return IncaricoMapper.toDTO(incaricoRepository.save(IncaricoMapper.toEnity(dati.s(), dati.c(), dati.d(), dati.m(), i.getProgramma())));
    }

    private Dati getDati(IncaricoDTO i) {
        IncaricoInputValidation.addIncaricoDTOValidation(i);
        Scuola s = scuolaService.getScuola(i.getScuolaDTO().getId());
        Classe c = classeService.getClasse(i.getClasseDTO().getId());
        IncaricoInputValidation.checkScuolaClasse(s, c);
        Docente d = docenteService.getDocente(i.getDocenteDTO().getId());
        Materia m = materiaService.getMateria(i.getMateriaDTO().getId());
        return new Dati(s, c, d, m);
    }

    private record Dati(Scuola s, Classe c, Docente d, Materia m) {
    }

    @Override
    public IncaricoDTO updateIncarico(IncaricoDTO i, int id) {
        Incarico originalEntity = incaricoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Incarico con id "+id+" non trovato"));
        Dati dati = getDati(i);
        return IncaricoMapper.toDTO(incaricoRepository.save(IncaricoMapper.toEnityUp(originalEntity, dati.s(), dati.c(), dati.d(), dati.m(), i.getProgramma())));
    }

    @Override
    public void deleteIncarico(int id) {
        getIncarico(id);
        incaricoRepository.deleteById(id);
    }
}

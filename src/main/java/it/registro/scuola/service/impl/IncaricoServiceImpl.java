package it.registro.scuola.service.impl;

import it.registro.scuola.dto.incarico.IncaricoDTO;
import it.registro.scuola.mapper.IncaricoMapper;
import it.registro.scuola.model.Classe;
import it.registro.scuola.model.Docente;
import it.registro.scuola.model.Materia;
import it.registro.scuola.model.Scuola;
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
        IncaricoInputValidation.addIncaricoDTOValidation(i);
        Scuola s = scuolaService.getScuola(i.getScuolaDTO().getId());
        Classe c = classeService.getClasse(i.getClasseDTO().getId());
        IncaricoInputValidation.checkScuolaClasse(s, c);
        Docente d = docenteService.getDocente(i.getDocenteDTO().getId());
        Materia m = materiaService.getMateria(i.getMateriaDTO().getId());
        return IncaricoMapper.toDTO(incaricoRepository.save(IncaricoMapper.toEnity(s, c, d, m)));
    }
}

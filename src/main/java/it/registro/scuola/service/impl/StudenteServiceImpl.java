package it.registro.scuola.service.impl;

import it.registro.scuola.dto.Studente.AddStudenteDTO;
import it.registro.scuola.dto.Studente.StudenteDTO;
import it.registro.scuola.mapper.StudenteMapper;
import it.registro.scuola.model.Classe;
import it.registro.scuola.model.Scuola;
import it.registro.scuola.model.Studente;
import it.registro.scuola.model.Utente;
import it.registro.scuola.repository.StudenteRepository;
import it.registro.scuola.service.StudenteService;
import it.registro.scuola.utilty.Ruolo;
import it.registro.scuola.validation.StudenteInputValidation;
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
    private ScuolaServiceImpl scuolaService;
    private ClasseServiceImpl classeService;
    private UtenteServiceImpl utenteService;

    @Override
    public StudenteDTO getStudente(int id) {
        return StudenteMapper.toDTO(studenteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Studente con id "+id+" non trovato")));
    }

    @Override
    public List<StudenteDTO> getStudentiByScuola(int idScuola) {
        return StudenteMapper.toListDTO(studenteRepository.findByClasseId(idScuola));
    }

    @Override
    public StudenteDTO addStudente(AddStudenteDTO s) {
        StudenteInputValidation.ValidationAddStudenteDTO(s);
        Scuola scuolaStudente = scuolaService.getScuola(s.getScuolaDTO().getId());
        Classe classeStudente = classeService.getClasse(s.getClasseDTO().getId());
        Studente enitityToSave = StudenteMapper.toEntity(s, scuolaStudente, classeStudente);
        StudenteDTO saved = StudenteMapper.toDTO(studenteRepository.save(enitityToSave));

        Utente newUser = new Utente(s.getUsername(), s.getPassword(), Ruolo.STU.toString(), saved.getId());
        utenteService.addUtente(newUser);

        return saved;
    }
}

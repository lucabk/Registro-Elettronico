package it.registro.scuola.service.impl;

import it.registro.scuola.dto.Studente.AddStudenteDTO;
import it.registro.scuola.dto.Studente.StudentIdDTO;
import it.registro.scuola.dto.Studente.StudenteDTO;
import it.registro.scuola.dto.utente.UpdateUtentePswDTO;
import it.registro.scuola.mapper.StudenteMapper;
import it.registro.scuola.model.Classe;
import it.registro.scuola.model.Scuola;
import it.registro.scuola.model.Studente;
import it.registro.scuola.model.Utente;
import it.registro.scuola.repository.StudenteRepository;
import it.registro.scuola.repository.UtenteRepository;
import it.registro.scuola.service.StudenteService;
import it.registro.scuola.utilty.Ruolo;
import it.registro.scuola.validation.StudenteInputValidation;
import it.registro.scuola.validation.UtenteInputValidation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private UtenteRepository utenteRepository;

    @Override
    public StudenteDTO getStudente(int id) {
        return StudenteMapper.toDTO(studenteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Studente con id "+id+" non trovato")));
    }
    public Studente getStudenteModel(int id) {
        return studenteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Studente con id "+id+" non trovato"));
    }

    @Override
    public List<StudenteDTO> getStudentiByScuola(int idScuola) {
        return StudenteMapper.toListDTO(studenteRepository.findByScuolaId(idScuola));
    }

    @Override
    public List<StudenteDTO> getStudentiByClasse(int idClasse) {
        return StudenteMapper.toListDTO(studenteRepository.findByClasseId(idClasse));
    }

    @Override
    public StudentIdDTO getIdStudenteByUsername(String username) {
        Utente u = utenteRepository.findByUsername(username);
        if(u == null) {
            throw new UsernameNotFoundException("Utente "+username+" non trovato");
        }
        return new StudentIdDTO( u.getRiferimentoId());
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

    @Override
    public StudenteDTO updateStudente(StudenteDTO s, int id) {
        StudenteInputValidation.ValidationStudenteDTO(s);
        Studente originalEntity = studenteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Studente con id "+id+" non trovato"));
        Studente entityUpdated = StudenteMapper.entityToUpdate(originalEntity, s);
        if(entityUpdated.getScuola().getId() != s.getScuolaDTO().getId() && entityUpdated.getClasse().getId() != s.getClasseDTO().getId()) {
            entityUpdated.setScuola(scuolaService.getScuola(s.getScuolaDTO().getId()));
            entityUpdated.setClasse(classeService.getClasse(s.getClasseDTO().getId()));
        }
        return StudenteMapper.toDTO(studenteRepository.save(entityUpdated));
    }

    @Override
    public void updatePswStudente(UpdateUtentePswDTO c, int id) {
        UtenteInputValidation.ValidationUpdateUtentePswDTO(c);
        getStudente(id);
        utenteService.upUtentePsw(id, c);
    }

    @Override
    public void deleteStudente(int id) {
        getStudente(id);
        studenteRepository.deleteById(id);
        utenteService.deleteUtente(id);
    }
}

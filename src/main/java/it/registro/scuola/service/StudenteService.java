package it.registro.scuola.service;

import it.registro.scuola.dto.Studente.AddStudenteDTO;
import it.registro.scuola.dto.Studente.StudentIdDTO;
import it.registro.scuola.dto.Studente.StudenteDTO;
import it.registro.scuola.dto.utente.UpdateUtentePswDTO;

import java.util.List;

public interface StudenteService {
    StudenteDTO getStudente(int id);
    List<StudenteDTO> getStudentiByScuola(int idScuola);
    List<StudenteDTO> getStudentiByClasse(int idClasse);
    StudentIdDTO getIdStudenteByUsername(String username);
    StudenteDTO addStudente(AddStudenteDTO s);
    StudenteDTO updateStudente(StudenteDTO s, int id);
    void updatePswStudente(UpdateUtentePswDTO c , int id);
    void deleteStudente(int id);
}

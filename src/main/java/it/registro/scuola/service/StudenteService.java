package it.registro.scuola.service;

import it.registro.scuola.dto.StudenteDTO;
import java.util.List;

public interface StudenteService {
    StudenteDTO getStudente(int id);
    List<StudenteDTO> getStudentiByScuola(int idScuola);
}

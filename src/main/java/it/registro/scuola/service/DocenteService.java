package it.registro.scuola.service;

import it.registro.scuola.dto.docente.AddDocenteDTO;
import it.registro.scuola.dto.docente.DocenteDTO;
import it.registro.scuola.dto.utente.UpdateUtentePswDTO;

import java.util.List;

public interface DocenteService {
    DocenteDTO getDocenteDTO(int id);
    List<DocenteDTO> getDocenti();
    DocenteDTO addDocente(AddDocenteDTO d);
    DocenteDTO updateDocente(DocenteDTO d, int id);
    void udpdatePswDocente(UpdateUtentePswDTO c, int id);
    void deleteDocente(int id);
}

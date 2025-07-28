package it.registro.scuola.service;

import it.registro.scuola.dto.docente.AddDocenteDTO;
import it.registro.scuola.dto.docente.DocenteDTO;

public interface DocenteService {
    DocenteDTO getDocente(int id);
    DocenteDTO addDocente(AddDocenteDTO d);
    DocenteDTO updateDocente(DocenteDTO d, int id);
}

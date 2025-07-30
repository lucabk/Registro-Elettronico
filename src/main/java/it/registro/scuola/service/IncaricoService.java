package it.registro.scuola.service;

import it.registro.scuola.dto.incarico.IncaricoDTO;
import java.util.List;

public interface IncaricoService {
    IncaricoDTO getIncarico(int id);
    List<IncaricoDTO> getIncaricoByScuola(int idScuola);
    List<IncaricoDTO> getIncaricoByClasse(int idClasse);
    IncaricoDTO addIncarico(IncaricoDTO i);
    IncaricoDTO updateIncarico(IncaricoDTO i, int id);
    void deleteIncarico(int id);
}

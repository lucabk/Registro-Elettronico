package it.registro.scuola.service;

import it.registro.scuola.dto.assenza.AssenzaDTO;
import java.util.List;

public interface AssenzaService {
    List<AssenzaDTO> getAssenzeByStudente(int idStudente);
    AssenzaDTO addAssenza(AssenzaDTO a);
}

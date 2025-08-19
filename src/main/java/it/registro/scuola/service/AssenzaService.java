package it.registro.scuola.service;

import it.registro.scuola.dto.assenza.AssenzaDTO;
import it.registro.scuola.dto.assenza.AssenzaResDTO;

import java.util.List;

public interface AssenzaService {
    List<AssenzaResDTO> getAssenzeByStudente(int idStudente);
    AssenzaDTO addAssenza(AssenzaDTO a);
    AssenzaDTO giustificaAssenza(AssenzaDTO a, int idAssenza);
    void cancellaAssenza(int id);
}

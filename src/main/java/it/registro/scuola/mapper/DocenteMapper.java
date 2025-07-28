package it.registro.scuola.mapper;

import it.registro.scuola.dto.docente.DocenteDTO;
import it.registro.scuola.model.Docente;

public class DocenteMapper {
    public static DocenteDTO toDTO(Docente d) {
        return new DocenteDTO(d.getId(), d.getNome(), d.getCognome(), d.getEmail(), d.getNumero(), d.getCodiceFiscale(),
                d.getIndirizzo(), d.getCitta(), d.getProvincia(), d.getCap(), d.getIstruzione());
    }
}

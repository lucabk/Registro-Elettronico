package it.registro.scuola.mapper;

import it.registro.scuola.dto.CompitiDTO;
import it.registro.scuola.model.Compiti;

public class CompitiMapper {
    public static CompitiDTO toDTO(Compiti c) {
        return new CompitiDTO(c.getId(), c.getEsercizi(), c.getDataConsegna(),IncaricoMapper.toDTO(c.getIncarico()));
    }
}

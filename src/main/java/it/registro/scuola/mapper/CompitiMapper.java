package it.registro.scuola.mapper;

import it.registro.scuola.dto.CompitiDTO;
import it.registro.scuola.model.Compiti;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompitiMapper {
    public static CompitiDTO toDTO(Compiti c) {
        return new CompitiDTO(c.getId(), c.getEsercizi(), c.getDataConsegna(),IncaricoMapper.toDTO(c.getIncarico()));
    }

    public static List<CompitiDTO> toListDTO(List<Compiti> c) {
        return c.stream().map(CompitiMapper::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }
}

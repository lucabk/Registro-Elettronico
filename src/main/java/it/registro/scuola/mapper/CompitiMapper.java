package it.registro.scuola.mapper;

import it.registro.scuola.dto.compiti.CompitiDTO;
import it.registro.scuola.dto.compiti.CompitoUpdateDTO;
import it.registro.scuola.model.Compiti;
import it.registro.scuola.model.Incarico;

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

    public static Compiti toEnitySave(CompitiDTO c, Incarico incarico) {
        Compiti toSave = new Compiti(c.getEsercizi(), c.getDataConsegna());
        toSave.setIncarico(incarico);
        return toSave;
    }


    public static Compiti toEnityUp(Compiti compitotoUp, CompitoUpdateDTO newCompito) {
        compitotoUp.setEsercizi(newCompito.getEsercizi());
        compitotoUp.setDataConsegna(newCompito.getDataConsegna());
        return compitotoUp;
    }
}

package it.registro.scuola.mapper;

import it.registro.scuola.dto.incarico.IncaricoDTO;
import it.registro.scuola.model.*;

import java.util.List;

public class IncaricoMapper {
    public static IncaricoDTO toDTO(Incarico i) {
        return new IncaricoDTO(i.getId(), ScuolaMapper.toDTO(i.getScuola()), ClasseMapper.toDTO(i.getClasse()),
                DocenteMapper.toDTO(i.getDocente()), MateriaMapper.toDTO(i.getMateria()));
    }

    public static List<IncaricoDTO> toListDTO(List<Incarico> l) {
        return l.stream().map(IncaricoMapper::toDTO).toList();
    }

    public static Incarico toEnity(Scuola s, Classe c, Docente d, Materia m) {
        Incarico newIncarico = new Incarico();
        newIncarico.setScuola(s);
        newIncarico.setClasse(c);
        newIncarico.setDocente(d);
        newIncarico.setMateria(m);
        return newIncarico;
    }

    public static Incarico toEnityUp(Incarico originalEntity, Scuola s, Classe c, Docente d, Materia m) {
        originalEntity.setScuola(s);
        originalEntity.setClasse(c);
        originalEntity.setDocente(d);
        originalEntity.setMateria(m);
        return originalEntity;
    }
}

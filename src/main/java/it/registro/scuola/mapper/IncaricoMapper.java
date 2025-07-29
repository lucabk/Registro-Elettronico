package it.registro.scuola.mapper;

import it.registro.scuola.dto.incarico.IncaricoDTO;
import it.registro.scuola.model.Incarico;

public class IncaricoMapper {
    public static IncaricoDTO toDTO(Incarico i) {
        return new IncaricoDTO(i.getId(), ScuolaMapper.toDTO(i.getScuola()), ClasseMapper.toDTO(i.getClasse()),
                DocenteMapper.toDTO(i.getDocente()), MateriaMapper.toDTO(i.getMateria()));
    }
}

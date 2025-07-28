package it.registro.scuola.mapper;

import it.registro.scuola.dto.MateriaDTO;
import it.registro.scuola.model.Materia;

public class MateriaMapper {
    public static MateriaDTO toDTO(Materia m) {
        return new MateriaDTO(m.getId(), m.getNome(), m.getCodice(), m.getProgramma());
    }

    public static Materia toEntity(MateriaDTO m) {
        return new Materia(m.getNome(), m.getCodice(), m.getProgramma());
    }

    public static Materia EntityToUpdate(Materia originalEntity, MateriaDTO m) {
        originalEntity.setNome(m.getNome());
        originalEntity.setCodice(m.getCodice());
        originalEntity.setProgramma(m.getProgramma());
        return originalEntity;
    }
}

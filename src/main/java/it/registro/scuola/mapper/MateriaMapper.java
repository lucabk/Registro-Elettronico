package it.registro.scuola.mapper;

import it.registro.scuola.dto.MateriaDTO;
import it.registro.scuola.model.Materia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MateriaMapper {
    public static MateriaDTO toDTO(Materia m) {
        return new MateriaDTO(m.getId(), m.getNome(), m.getCodice());
    }

    public static Materia toEntity(MateriaDTO m) {
        return new Materia(m.getNome(), m.getCodice());
    }

    public static Materia EntityToUpdate(Materia originalEntity, MateriaDTO m) {
        originalEntity.setNome(m.getNome());
        originalEntity.setCodice(m.getCodice());
        return originalEntity;
    }

    public static List<MateriaDTO> toDTOList(List<Materia> m) {
        return m.stream().map(MateriaMapper::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }
}

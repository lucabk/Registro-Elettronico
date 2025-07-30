package it.registro.scuola.service;

import it.registro.scuola.dto.MateriaDTO;

import java.util.List;

public interface MateriaService {
    MateriaDTO getMateriaDTO(int id);
    List<MateriaDTO> getMaterie();
    MateriaDTO addMateria(MateriaDTO m);
    MateriaDTO updateMateria(MateriaDTO m, int id);
    void deleteMateria(int id);
}

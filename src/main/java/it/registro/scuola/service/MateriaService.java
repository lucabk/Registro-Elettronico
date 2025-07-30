package it.registro.scuola.service;

import it.registro.scuola.dto.MateriaDTO;

public interface MateriaService {
    MateriaDTO getMateriaDTO(int id);
    MateriaDTO addMateria(MateriaDTO m);
    MateriaDTO updateMateria(MateriaDTO m, int id);
    void deleteMateria(int id);
}

package it.registro.scuola.service;

import it.registro.scuola.dto.MateriaDTO;

public interface MateriaService {
    MateriaDTO getMateria(int id);
    MateriaDTO addMateria(MateriaDTO m);
}

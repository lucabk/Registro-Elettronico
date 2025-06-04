package it.registro.scuola.service;

import java.util.List;

import it.registro.scuola.dto.ClasseDTO;

public interface ClasseService {

	List<ClasseDTO> getClassiDTO();

	ClasseDTO getClasseDTO(int id);

}
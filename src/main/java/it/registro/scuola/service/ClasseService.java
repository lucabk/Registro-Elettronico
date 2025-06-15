package it.registro.scuola.service;

import java.util.List;

import it.registro.scuola.dto.ClasseDTO;

public interface ClasseService {

	List<ClasseDTO> getClassiDTO();
	
	List<ClasseDTO> getClassiByIdScuolaDTO(int idScuola);

	ClasseDTO getClasseDTO(int id);
	
	ClasseDTO addClasseDTO(ClasseDTO c);
	
	ClasseDTO updateClasseDTO(ClasseDTO c, int classeId);
	
	void deleteClasseById(int idClasse);

}
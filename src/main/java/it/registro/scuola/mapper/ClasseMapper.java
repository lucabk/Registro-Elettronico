package it.registro.scuola.mapper;

import it.registro.scuola.dto.ClasseDTO;
import it.registro.scuola.model.Classe;

public class ClasseMapper {
	public static ClasseDTO toDTO(Classe c) {
		return new ClasseDTO(c.getId(), c.getGrado(), c.getLettera(), c.getAnnoScolastico(), ScuolaMapper.toDTO(c.getScuola()));
	}


}

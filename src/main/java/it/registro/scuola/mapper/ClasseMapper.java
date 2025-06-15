package it.registro.scuola.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import it.registro.scuola.dto.ClasseDTO;
import it.registro.scuola.model.Classe;

public class ClasseMapper {
	public static ClasseDTO toDTO(Classe c) {
		return new ClasseDTO(c.getId(), c.getGrado(), c.getLettera(), c.getAnnoScolastico(), ScuolaMapper.toDTO(c.getScuola()));
	}
	
	public static List<ClasseDTO> toListDTO(List<Classe> listClassi) {
		return listClassi.stream().map(c -> toDTO(c)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static Classe toEntity(ClasseDTO c) {
		return new Classe(c.getGrado(), c.getLettera(), c.getAnnoScolastico());
	}

	public static Classe entityToUp(Classe oEn, ClasseDTO newEn) {
		oEn.setGrado(newEn.getGrado());
		oEn.setLettera(newEn.getLettera());
		oEn.setAnnoScolastico(newEn.getAnnoScolastico());
		return oEn;
	}
}

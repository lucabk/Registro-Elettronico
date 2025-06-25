package it.registro.scuola.mapper;

import java.util.*;
import java.util.stream.Collectors;
import it.registro.scuola.dto.SegreteriaDTO;
import it.registro.scuola.dto.register.AddSegreteriaReqDTO;
import it.registro.scuola.model.Segreteria;

public class SegreteriaMapper {
	public static SegreteriaDTO toDTO(Segreteria s) {
		return new SegreteriaDTO(s.getId(), s.getNome(), ScuolaMapper.toDTO(s.getScuola()));
	}

	public static List<SegreteriaDTO> toListDTO(List<Segreteria> ls) {
		return ls.stream().map(s -> toDTO(s)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static Segreteria toEntity(SegreteriaDTO s) {
		return new Segreteria(s.getNome());
	}

	public static Segreteria toEntity(AddSegreteriaReqDTO s) {
		return new Segreteria(s.getNome());
	}
	
	public static Segreteria entityToUp(Segreteria oEn, SegreteriaDTO s) {
		oEn.setNome(s.getNome());
		return oEn;
	}
}

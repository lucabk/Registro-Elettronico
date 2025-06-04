package it.registro.scuola.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.model.Scuola;

public class ScuolaMapper {

	public static ScuolaDTO toDTO(Scuola s) {
		return new ScuolaDTO(s.getId(), s.getNome(), s.getTipo(), s.getIndirizzo(), s.getCitta(), s.getProvincia(),
				s.getCap(), s.getRegione());
	}

	public static Scuola toEntity(ScuolaDTO s) {
		return new Scuola(s.getNome(), s.getTipo(), s.getIndirizzo(), s.getCitta(), s.getProvincia(), s.getCap(),
				s.getRegione());
	}

	public static List<ScuolaDTO> toListDTO(List<Scuola> listScuole) {
		return listScuole.stream().map(s -> toDTO(s)).collect(Collectors.toCollection(ArrayList::new));
	}

	public static Scuola entityToUp(Scuola oEn, ScuolaDTO newEn) {
		oEn.setNome(newEn.getNome());
		oEn.setTipo(newEn.getTipo());
		oEn.setIndirizzo(newEn.getIndirizzo());
		oEn.setCitta(newEn.getCitta());
		oEn.setProvincia(newEn.getProvincia());
		oEn.setCap(newEn.getCap());
		oEn.setRegione(newEn.getRegione());
		return oEn;
	}
}

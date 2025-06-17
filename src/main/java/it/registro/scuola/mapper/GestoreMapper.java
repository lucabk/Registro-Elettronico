package it.registro.scuola.mapper;

import it.registro.scuola.dto.GestoreDTO;
import it.registro.scuola.model.Gestore;

public class GestoreMapper {
	public static GestoreDTO toDTO(Gestore g) {
		return new GestoreDTO(g.getId(), g.getUsername(), g.getPsw());
	}
}

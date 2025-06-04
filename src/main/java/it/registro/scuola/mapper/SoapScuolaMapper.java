package it.registro.scuola.mapper;

import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.model.soap.Scuola;
import it.registro.scuola.model.soap.ScuolaUpdate;

public class SoapScuolaMapper {
	public static Scuola toSoap(ScuolaDTO s) {
		Scuola sSoap = new Scuola();
		sSoap.setId(s.getId());
		sSoap.setNome(s.getNome());
		sSoap.setTipo(s.getTipo());
		sSoap.setIndirizzo(s.getIndirizzo());
		sSoap.setCitta(s.getCitta());
		sSoap.setProvincia(s.getProvincia());
		sSoap.setCap(s.getCap());
		sSoap.setRegione(s.getRegione());
		return sSoap;
	}

	public static ScuolaUpdate toSoapUp(ScuolaDTO s) {
		ScuolaUpdate sSoap = new ScuolaUpdate();
		sSoap.setId(s.getId());
		sSoap.setNome(s.getNome());
		sSoap.setTipo(s.getTipo());
		sSoap.setIndirizzo(s.getIndirizzo());
		sSoap.setCitta(s.getCitta());
		sSoap.setProvincia(s.getProvincia());
		sSoap.setCap(s.getCap());
		sSoap.setRegione(s.getRegione());
		return sSoap;
	}

	public static ScuolaDTO toDTO(Scuola s) {
		ScuolaDTO dto = new ScuolaDTO();
		dto.setNome(s.getNome());
		dto.setTipo(s.getTipo());
		dto.setIndirizzo(s.getIndirizzo());
		dto.setCitta(s.getCitta());
		dto.setProvincia(s.getProvincia());
		dto.setCap(s.getCap());
		dto.setRegione(s.getRegione());
		return dto;
	}

	public static ScuolaDTO toDTOfromUp(ScuolaUpdate s) {
		ScuolaDTO dto = new ScuolaDTO();
		dto.setId(s.getId());
		dto.setNome(s.getNome());
		dto.setTipo(s.getTipo());
		dto.setIndirizzo(s.getIndirizzo());
		dto.setCitta(s.getCitta());
		dto.setProvincia(s.getProvincia());
		dto.setCap(s.getCap());
		dto.setRegione(s.getRegione());
		return dto;
	}
}

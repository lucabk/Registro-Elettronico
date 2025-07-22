package it.registro.scuola.service;

import java.util.List;
import it.registro.scuola.dto.ScuolaDTO;

public interface ScuolaService {

	List<ScuolaDTO> getScuoleDTO();

	ScuolaDTO getScuolaDTO(int id);

	ScuolaDTO addScuolaDTO(ScuolaDTO s);

	ScuolaDTO updateScuolaDTO(ScuolaDTO s);
	
	ScuolaDTO updateScuolaDTO(int scuolaId, ScuolaDTO s);

	boolean deleteScuola(int id);
	
	void deleteByIdScuola(int id);

	List<ScuolaDTO> getScuoleByRegioneDTO(String r);

	List<ScuolaDTO> getScuoleByProvinciaDTO(String p);

	List<ScuolaDTO> getScuoleByCittaDTO(String c);

	List<ScuolaDTO> getScuoleByRegioneAndProvinciaDTO(String r, String p);

	List<ScuolaDTO> getScuoleByRegioneAndCittaDTO(String r, String c);

	List<ScuolaDTO> getScuoleByProvinciaAndCittaDTO(String p, String c);
}
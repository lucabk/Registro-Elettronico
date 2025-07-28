package it.registro.scuola.service;

import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.dto.segreteria.SegreteriaDTO;
import it.registro.scuola.dto.segreteria.AddSegreteriaReqDTO;
import it.registro.scuola.dto.segreteria.AddSegreteriaResDTO;
import it.registro.scuola.dto.utente.UpdateUtentePswDTO;

import java.util.*;

public interface SegreteriaService {

	SegreteriaDTO getSegreteria(int id);
	
	List<SegreteriaDTO> getSegreterie();
	
	List<SegreteriaDTO> getSegreterieByScuola(int idScuola);

	AddSegreteriaResDTO addSegreteria(AddSegreteriaReqDTO s);
	
	void updateSegreteria(SegreteriaDTO s, int id);

	void updateSegreteriaPassword(UpdateUtentePswDTO c, int id);
	
	void deleteSegreteria(int id);

	ScuolaDTO getScuolaByUsername(String username);
}

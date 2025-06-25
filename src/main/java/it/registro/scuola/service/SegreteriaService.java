package it.registro.scuola.service;

import it.registro.scuola.dto.segreteria.SegreteriaDTO;
import it.registro.scuola.dto.segreteria.AddSegreteriaReqDTO;
import it.registro.scuola.dto.segreteria.AddSegreteriaResDTO;
import it.registro.scuola.dto.segreteria.UpSegreteriaPswDTO;

import java.util.*;

public interface SegreteriaService {

	SegreteriaDTO getSegreteria(int id);
	
	List<SegreteriaDTO> getSegreterie();
	
	List<SegreteriaDTO> getSegreterieByScuola(int idScuola);

	AddSegreteriaResDTO addSegreteria(AddSegreteriaReqDTO s);
	
	void updateSegreteria(SegreteriaDTO s, int id);

	void updateSegreteriaPassword(UpSegreteriaPswDTO s, int id);
	
	void deleteSegreteria(int id);
	
}

package it.registro.scuola.service;

import it.registro.scuola.dto.SegreteriaDTO;
import it.registro.scuola.dto.register.AddSegreteriaReqDTO;
import it.registro.scuola.dto.register.AddSegreteriaResDTO;

import java.util.*;

public interface SegreteriaService {

	SegreteriaDTO getSegreteria(int id);
	
	List<SegreteriaDTO> getSegreterie();
	
	List<SegreteriaDTO> getSegreterieByScuola(int idScuola);

	AddSegreteriaResDTO addSegreteria(AddSegreteriaReqDTO s);
	
	void updateSegreteria(SegreteriaDTO s, int id);
	
	void deleteSegreteria(int id);
	
}

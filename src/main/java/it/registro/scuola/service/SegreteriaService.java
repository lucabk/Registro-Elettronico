package it.registro.scuola.service;

import it.registro.scuola.dto.SegreteriaDTO;
import java.util.*;

public interface SegreteriaService {

	SegreteriaDTO getSegreteria(int id);
	
	List<SegreteriaDTO> getSegreterie();
	
	List<SegreteriaDTO> getSegreterieByScuola(int idScuola);
	
	SegreteriaDTO addSegreteria(SegreteriaDTO s);
	
	void updateSegreteria(SegreteriaDTO s, int id);
	
	void deleteSegreteria(int id);
	
}

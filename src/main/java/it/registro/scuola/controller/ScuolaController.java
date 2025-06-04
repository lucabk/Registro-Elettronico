package it.registro.scuola.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.service.ScuolaService;

@RestController
@RequestMapping("/api")
public class ScuolaController {
	
	@Autowired
	private ScuolaService scuolaService;
	
	@GetMapping("/scuole")
	public ResponseEntity<List<ScuolaDTO>> getScuole(
			@RequestParam(required=false) String citta,
			@RequestParam(required=false) String regione,
			@RequestParam(required=false) String provincia) {
		
		List<ScuolaDTO> scuole = scuolaFilterQuery(citta, regione, provincia);
		return ResponseEntity.ok(scuole);
	}

	private List<ScuolaDTO> scuolaFilterQuery(String citta, String regione, String provincia) {
		List<ScuolaDTO> scuole = new ArrayList<ScuolaDTO>();
		if(regione != null && provincia == null && citta == null) {
			scuole = scuolaService.getScuoleByRegioneDTO(regione);
		} else if(regione == null && provincia != null && citta == null) {
			scuole = scuolaService.getScuoleByProvinciaDTO(provincia);
		} else if(regione == null && provincia == null && citta != null) {
			scuole = scuolaService.getScuoleByCittaDTO(citta);
		} else if(regione != null && provincia != null && citta == null) {
			scuole = scuolaService.getScuoleByRegioneAndProvinciaDTO(regione, provincia);
		} else if(regione != null && provincia == null && citta != null) {
			scuole = scuolaService.getScuoleByRegioneAndCittaDTO(regione, citta);
		} else if(regione == null && provincia != null && citta != null) {
			scuole = scuolaService.getScuoleByProvinciaAndCittaDTO(provincia, citta);
		}
		else {
			scuole = scuolaService.getScuoleDTO(); 
		}
		return scuole;
	}
	
	@GetMapping("/scuole/{id}")
	public ResponseEntity<ScuolaDTO> getScuola(@PathVariable("id") int idScuola) {
		return ResponseEntity.ok(scuolaService.getScuolaDTO(idScuola));
	}
}

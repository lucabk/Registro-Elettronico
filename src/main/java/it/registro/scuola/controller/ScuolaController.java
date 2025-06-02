package it.registro.scuola.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.service.ScuolaService;

@RestController
@RequestMapping("/api")
public class ScuolaController {
	
	@Autowired
	private ScuolaService scuolaService;
	
	@GetMapping("/scuole")
	public ResponseEntity<List<ScuolaDTO>> getScuole() {
		List<ScuolaDTO> scuole = scuolaService.getScuoleDTO(); 
		return ResponseEntity.ok(scuole);
	}
	
	@GetMapping("/scuole/{id}")
	public ResponseEntity<ScuolaDTO> getScuola(@PathVariable("id") int idScuola) {
		return ResponseEntity.ok(scuolaService.getScuolaDTO(idScuola));
	}
}

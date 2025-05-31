package it.registro.scuola.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		try {
			List<ScuolaDTO> scuole = new ArrayList<>();
			scuolaService.getScuoleDTO().forEach(scuole::add);
			if(scuole.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(scuole, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

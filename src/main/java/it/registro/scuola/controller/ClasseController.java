package it.registro.scuola.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.registro.scuola.dto.ClasseDTO;
import it.registro.scuola.model.Classe;
import it.registro.scuola.service.ClasseService;

@RestController
@RequestMapping("/api")
public class ClasseController {

	@Autowired
	private ClasseService classeService;
	
	@GetMapping("/classi")
	public ResponseEntity<List<ClasseDTO>> getClassi() {
		try {
			List<ClasseDTO> classi = new ArrayList<>();
			classeService.getClassiDTO().forEach(classi::add);
			if(classi.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(classi, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

package it.registro.scuola.controller;

import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.registro.scuola.dto.ClasseDTO;
import it.registro.scuola.service.impl.ClasseServiceImpl;
import lombok.AllArgsConstructor;

//////////////////////
///
///CORS TEMPORANEO
///////////////////
///
@CrossOrigin(origins = "http://localhost:5173")

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ClasseController {

	private ClasseServiceImpl classeService;

	@GetMapping("/classi")
	public ResponseEntity<List<ClasseDTO>> getClassi(
			@RequestParam(required=false) Integer idScuola) {
		List<ClasseDTO> classi = new ArrayList<ClasseDTO>();
		if(idScuola != null) {
			classi = classeService.getClassiByIdScuolaDTO(idScuola);		
		} else {
			classi = classeService.getClassiDTO();			
		}
		return ResponseEntity.ok(classi);
	}
	
	@GetMapping("/classi/{id}")
	public ResponseEntity<ClasseDTO> getClasse(@PathVariable("id") int idClasse) {
		return ResponseEntity.ok(classeService.getClasseDTO(idClasse));
	}
}
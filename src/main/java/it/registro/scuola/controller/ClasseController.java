package it.registro.scuola.controller;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.registro.scuola.dto.ClasseDTO;
import it.registro.scuola.service.impl.ClasseServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/classi")
public class ClasseController {

	private ClasseServiceImpl classeService;

	@PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
	@GetMapping
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

	@PreAuthorize("hasAnyRole('GES', 'SEG', 'DOC')")
	@GetMapping("{id}")
	public ResponseEntity<ClasseDTO> getClasse(@PathVariable("id") int idClasse) {
		return ResponseEntity.ok(classeService.getClasseDTO(idClasse));
	}

	@PreAuthorize("hasAnyRole('GES', 'SEG')")
	@PostMapping
	public ResponseEntity<ClasseDTO> addClasse(@Valid @RequestBody ClasseDTO c) {
		ClasseDTO classeSalvata = classeService.addClasseDTO(c); 
		return ResponseEntity.status(HttpStatus.CREATED).body(classeSalvata);
	}

	@PreAuthorize("hasAnyRole('GES', 'SEG')")
	@PutMapping("{id}")
	public ResponseEntity<ClasseDTO> updateClasse(@Valid @RequestBody ClasseDTO s, @PathVariable("id") int classeId) {
		ClasseDTO classeAggiornata = classeService.updateClasseDTO(s, classeId);
		return ResponseEntity.ok(classeAggiornata);
	}

	@PreAuthorize("hasAnyRole('GES')")
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteClasse(@PathVariable("id") int classeId) {
		classeService.deleteClasseById(classeId);
		return ResponseEntity.noContent().build();
	}
}
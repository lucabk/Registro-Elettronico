package it.registro.scuola.controller;

import java.util.*;

import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.dto.segreteria.AddSegreteriaReqDTO;
import it.registro.scuola.dto.segreteria.AddSegreteriaResDTO;
import it.registro.scuola.dto.segreteria.UpSegreteriaPswDTO;
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
import it.registro.scuola.dto.segreteria.SegreteriaDTO;
import it.registro.scuola.service.impl.SegreteriaServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@PreAuthorize("hasAnyRole('GES', 'SEG')")
@RequestMapping("/api/segreterie")
public class SegreteriaController {
	private SegreteriaServiceImpl segreteriaService;
	
	@GetMapping
	public ResponseEntity<List<SegreteriaDTO>> getSegreterie(@RequestParam(required=false) Integer idScuola) {
		List<SegreteriaDTO> s = new ArrayList<>();
		if(idScuola != null) {
			s = segreteriaService.getSegreterieByScuola(idScuola);
		} else {
			s = segreteriaService.getSegreterie();
		}
		return ResponseEntity.ok(s);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SegreteriaDTO> getSegreteria(@PathVariable("id") int idSegreteria) {
		return ResponseEntity.ok(segreteriaService.getSegreteria(idSegreteria));
	}
	
	@PostMapping()
	public ResponseEntity<AddSegreteriaResDTO> addSegreteria(@Valid @RequestBody AddSegreteriaReqDTO s) {
		return ResponseEntity.status(HttpStatus.CREATED).body(segreteriaService.addSegreteria(s));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> updateSegreteria(@Valid @RequestBody SegreteriaDTO s, @PathVariable("id") int idSegreteria) {
		segreteriaService.updateSegreteria(s, idSegreteria);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("u{id}")
	public ResponseEntity<Void> updateSegreteriaPsw(@Valid @RequestBody UpSegreteriaPswDTO s, @PathVariable("id") int idSegreteria) {
		segreteriaService.updateSegreteriaPassword(s, idSegreteria);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteSegreteria(@PathVariable int id){
		segreteriaService.deleteSegreteria(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/utente/{username}")
	public ResponseEntity<ScuolaDTO> getScuolaBySegreteria(@PathVariable("username") String username) {
		return ResponseEntity.ok(segreteriaService.getScuolaByUsername(username));
	}
}

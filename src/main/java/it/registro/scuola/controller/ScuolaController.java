package it.registro.scuola.controller;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.service.impl.ScuolaServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

//////////////////////
///
///CORS TEMPORANEO
///////////////////
///
@CrossOrigin(origins = "http://localhost:5173")

@AllArgsConstructor
@RestController
@RequestMapping("/api/scuole")
public class ScuolaController {
	
	private ScuolaServiceImpl scuolaService;
	
	@GetMapping
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
	
	@GetMapping("{id}")
	public ResponseEntity<ScuolaDTO> getScuola(@PathVariable("id") int idScuola) {
		return ResponseEntity.ok(scuolaService.getScuolaDTO(idScuola));
	}
	
	@PostMapping
	public ResponseEntity<ScuolaDTO> addScuola(@Valid @RequestBody ScuolaDTO s) {
		ScuolaDTO scuolaSalvataDTO = scuolaService.addScuolaDTO(s);
		return ResponseEntity.status(HttpStatus.CREATED).body(scuolaSalvataDTO);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ScuolaDTO> updateScuola(@PathVariable("id") int scuolaId, @Valid @RequestBody ScuolaDTO s) {
		ScuolaDTO scuolaAggiornataDTO = scuolaService.updateScuolaDTO(scuolaId, s);
		return ResponseEntity.ok(scuolaAggiornataDTO);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteScuola(@PathVariable("id") int idScuola) {
		scuolaService.deleteByIdScuola(idScuola);
		return ResponseEntity.noContent().build();
	}
}

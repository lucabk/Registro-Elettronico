package it.registro.scuola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.registro.scuola.dto.GestoreDTO;
import it.registro.scuola.service.impl.GestoreServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/gestori")
public class GestoreController {
	private GestoreServiceImpl gestoreService;

	@GetMapping("{id}")
	public ResponseEntity<GestoreDTO> getGestore(@PathVariable int id){
		return ResponseEntity.ok(gestoreService.getGestore(id));
	}
}

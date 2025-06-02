package it.registro.scuola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.model.Scuola;
import it.registro.scuola.repository.ScuolaRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScuolaService {

	@Autowired
	private ScuolaRepository scuolaRepository;
	
	private List<Scuola> getScuole() {
		return scuolaRepository.findAll();
	}
	
	public List<ScuolaDTO> getScuoleDTO() {
		return getScuole().stream().map(s -> toDTO(s)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	private Optional<Scuola> getScuola(int id) {
		return scuolaRepository.findById(id);
	}
	
	public ScuolaDTO getScuolaDTO(int id){
		return toDTO(getScuola(id).orElseThrow(() -> new EntityNotFoundException("Scuola con id "+ id + " non travata")));
	}
	
	//DTO helper methods
	private ScuolaDTO toDTO(Scuola s) {
		return new ScuolaDTO(s.getId(), s.getNome(), s.getTipo(), s.getIndirizzo(), s.getCitta(), s.getProvincia(), s.getCap(), s.getRegione());
	}
}

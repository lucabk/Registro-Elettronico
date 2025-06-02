package it.registro.scuola.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.registro.scuola.dto.ClasseDTO;
import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.model.Classe;
import it.registro.scuola.model.Scuola;
import it.registro.scuola.repository.ClasseRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClasseService {
	
	@Autowired
	private ClasseRepository classeRepository;
	
	private List<Classe> getClassi() {
		return classeRepository.findAll();
	}
	
	public List<ClasseDTO> getClassiDTO() {
		return getClassi().stream().map(s -> toDTO(s)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	private Optional<Classe> getClasse(int id) {
		return classeRepository.findById(id);
	}
	
	public ClasseDTO getClasseDTO(int id) {
		return toDTO(getClasse(id).orElseThrow(() -> new EntityNotFoundException("Classe con id "+ id + " non travata")));
	}
	
	
	//DTO helper methods
	private ClasseDTO toDTO(Classe c) {
		return new ClasseDTO(c.getId(), c.getGrado(), c.getLettera(), c.getAnnoScolastico(), toDTO(c.getScuola()));
	}
	
	private ScuolaDTO toDTO(Scuola s) {
		return new ScuolaDTO(s.getId(), s.getNome(), s.getTipo(), s.getIndirizzo(), s.getCitta(), s.getProvincia(), s.getCap(), s.getRegione());
	}
}

package it.registro.scuola.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.registro.scuola.dto.ClasseDTO;
import it.registro.scuola.model.Classe;
import it.registro.scuola.repository.ClasseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClasseService {
	
	@Autowired
	private ClasseRepository classeRepository;
	
	public List<Classe> getClassi() {
		return classeRepository.findAll();
	}
	
	public List<ClasseDTO> getClassiDTO() {
		return getClassi().stream().map(s -> toDTO(s)).collect(Collectors.toCollection(ArrayList::new));
	}

	private ClasseDTO toDTO(Classe c) {
		return new ClasseDTO(c.getId_classe(), c.getGrado(), c.getLettera(), c.getAnnoScolastico(), c.getScuola().getNome(), c.getScuola().getTipo(), c.getScuola().getCitta());
	}
}

package it.registro.scuola.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.registro.scuola.dto.ClasseDTO;
import it.registro.scuola.mapper.ClasseMapper;
import it.registro.scuola.model.Classe;
import it.registro.scuola.repository.ClasseRepository;
import it.registro.scuola.service.ClasseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class ClasseServiceImpl implements ClasseService {
	
	private ClasseRepository classeRepository;
	
	private List<Classe> getClassi() {
		return classeRepository.findAll();
	}
	
	@Override
	public List<ClasseDTO> getClassiDTO() {
		return getClassi().stream().map(s -> ClasseMapper.toDTO(s)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	private Optional<Classe> getClasse(int id) {
		return classeRepository.findById(id);
	}
	
	@Override
	public ClasseDTO getClasseDTO(int id) {
		return ClasseMapper.toDTO(getClasse(id).orElseThrow(() -> new EntityNotFoundException("Classe con id "+ id + " non travata")));
	}
	

}

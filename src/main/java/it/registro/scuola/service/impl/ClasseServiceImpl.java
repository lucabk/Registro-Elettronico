package it.registro.scuola.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.registro.scuola.dto.ClasseDTO;
import it.registro.scuola.mapper.ClasseMapper;
import it.registro.scuola.model.Classe;
import it.registro.scuola.model.Scuola;
import it.registro.scuola.repository.ClasseRepository;
import it.registro.scuola.service.ClasseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import java.util.List;


@AllArgsConstructor
@Service
@Transactional
public class ClasseServiceImpl implements ClasseService {

	private ClasseRepository classeRepository;
	private ScuolaServiceImpl scuolaService;  

	private List<Classe> getClassi() {
		return classeRepository.findAll();
	}
	
	@Override
	public List<ClasseDTO> getClassiDTO() {
		return ClasseMapper.toListDTO(getClassi());
	}
	
	private Classe getClasse(int id) {
		return classeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Classe con id " + id + " non travata"));
	}
	
	@Override
	public ClasseDTO getClasseDTO(int id) {
		return ClasseMapper.toDTO(getClasse(id));
	}

	private List<Classe> getClassiByIdScuola(int idScuola) {
		return classeRepository.findByScuolaId(idScuola);	
	}
	
	@Override
	public List<ClasseDTO> getClassiByIdScuolaDTO(int idScuola) {
		return ClasseMapper.toListDTO(getClassiByIdScuola(idScuola));
	}

	private Classe addClasse(Classe c) {
		return classeRepository.save(c);
	}
	
	@Override
	public ClasseDTO addClasseDTO(ClasseDTO c) {
		if(c.getScuolaDTO() == null) {
			throw new IllegalArgumentException("E' obbliglatorio specificare la scuola a cui aggiungere la classe");
		}
		Scuola scuola = scuolaService.getScuola(c.getScuolaDTO().getId());
		Classe classeDaSalvare = ClasseMapper.toEntity(c);
		classeDaSalvare.setScuola(scuola); 
		return ClasseMapper.toDTO(addClasse(classeDaSalvare));
	}

	private Classe updateClasse(Classe c) {
		return classeRepository.save(c);
	}
	
	@Override
	public ClasseDTO updateClasseDTO(ClasseDTO c, int classeId) {
		Classe originalEntity = getClasse(classeId);
		return ClasseMapper.toDTO(updateClasse(ClasseMapper.entityToUp(originalEntity, c)));
	}

	@Override
	public void deleteClasseById(int idClasse) {
		getClasse(idClasse);
		classeRepository.deleteById(idClasse);
	}
	

}

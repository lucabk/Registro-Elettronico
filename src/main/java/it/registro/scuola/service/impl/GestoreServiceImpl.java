package it.registro.scuola.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.registro.scuola.dto.GestoreDTO;
import it.registro.scuola.mapper.GestoreMapper;
import it.registro.scuola.repository.GestoreRepository;
import it.registro.scuola.service.GestoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class GestoreServiceImpl implements GestoreService{
	
	private GestoreRepository gestoreRepository;

	@Override
	public GestoreDTO getGestore(int id) {
		return GestoreMapper.toDTO(gestoreRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Gestore con id "+ id + " non trovato")));
	}

}

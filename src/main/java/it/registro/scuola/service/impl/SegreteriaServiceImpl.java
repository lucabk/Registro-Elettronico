package it.registro.scuola.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import it.registro.scuola.dto.SegreteriaDTO;
import it.registro.scuola.mapper.ScuolaMapper;
import it.registro.scuola.mapper.SegreteriaMapper;
import it.registro.scuola.model.Scuola;
import it.registro.scuola.model.Segreteria;
import it.registro.scuola.service.SegreteriaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import it.registro.scuola.repository.SegreteriaRepository;

@AllArgsConstructor
@Service
@Transactional
public class SegreteriaServiceImpl implements SegreteriaService{
	private SegreteriaRepository segreteriaRepository;
	private ScuolaServiceImpl scuolaService;

	@Override
	public SegreteriaDTO getSegreteria(int id) {
		return SegreteriaMapper.toDTO(segreteriaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Segreteria con id "+id+" non trovata")));
	}

	@Override
	public List<SegreteriaDTO> getSegreterie() {
		return SegreteriaMapper.toListDTO(segreteriaRepository.findAll());
	}

	@Override
	public List<SegreteriaDTO> getSegreterieByScuola(int idScuola) {
		return SegreteriaMapper.toListDTO(segreteriaRepository.findByScuolaId(idScuola));
	}

	@Override
	public SegreteriaDTO addSegreteria(SegreteriaDTO s) {
		if(s.getScuolaDTO() == null) {
			throw new IllegalArgumentException("E' obbliglatorio specificare la scuola a cui aggiungere la segreteria");
		}
		Scuola scuola = scuolaService.getScuola(s.getScuolaDTO().getId());
		Segreteria entity = SegreteriaMapper.toEntity(s);
		entity.setScuola(scuola);
		return SegreteriaMapper.toDTO(segreteriaRepository.save(entity));
	}

	@Override 
	public void updateSegreteria(SegreteriaDTO s, int id) {
		Segreteria originalEntity = segreteriaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Segreteria con id "+id+" non trovata"));
		Segreteria sToUp = SegreteriaMapper.entityToUp(originalEntity, s);
		if(s.getScuolaDTO() != null && ScuolaMapper.toDTO(originalEntity.getScuola()) != s.getScuolaDTO()) {
			Scuola scuola = scuolaService.getScuola(s.getScuolaDTO().getId());
			sToUp.setScuola(scuola);
		}
		segreteriaRepository.save(sToUp);
	}

	@Override
	public void deleteSegreteria(int id) {
		segreteriaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Segreteria con id "+id+" non trovata"));
		segreteriaRepository.deleteById(id);
	}

}

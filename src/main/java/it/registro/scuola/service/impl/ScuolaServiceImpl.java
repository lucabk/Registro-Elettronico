package it.registro.scuola.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.mapper.ScuolaMapper;
import it.registro.scuola.model.Scuola;
import it.registro.scuola.repository.ScuolaRepository;
import it.registro.scuola.service.ScuolaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class ScuolaServiceImpl implements ScuolaService {

	private ScuolaRepository scuolaRepository;

	private List<Scuola> getScuole() {
		return scuolaRepository.findAll();
	}

	@Override
	public List<ScuolaDTO> getScuoleDTO() {
		return ScuolaMapper.toListDTO(getScuole());
	}

	protected Scuola getScuola(int id) {
		return scuolaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Scuola con id " + id + " non travata"));
	}

	@Override
	public ScuolaDTO getScuolaDTO(int id) {
		return ScuolaMapper.toDTO(getScuola(id));
	}

	private Scuola addScuola(Scuola s) {
		return scuolaRepository.save(s);
	}

	@Override
	public ScuolaDTO addScuolaDTO(ScuolaDTO s) {
		return ScuolaMapper.toDTO(addScuola(ScuolaMapper.toEntity(s)));
	}

	private Scuola updateScuola(Scuola s) {
		return scuolaRepository.save(s);
	}

	@Override // SOAP
	public ScuolaDTO updateScuolaDTO(ScuolaDTO s) {
		Scuola originalEntity = getScuola(s.getId());
		return ScuolaMapper.toDTO(updateScuola(ScuolaMapper.entityToUp(originalEntity, s)));
	}

	@Override // REST
	public ScuolaDTO updateScuolaDTO(int scuolaId, ScuolaDTO s) {
		Scuola originalEntity = getScuola(scuolaId);
		return ScuolaMapper.toDTO(updateScuola(ScuolaMapper.entityToUp(originalEntity, s)));
	}

	@Override // SOAP
	public boolean deleteScuola(int id) {
		scuolaRepository.delete(getScuola(id));
		return true;
	}

	@Override
	public void deleteByIdScuola(int id) {
		getScuola(id);
		scuolaRepository.deleteById(id);
	}

	// filtri per cercare scuole
	private List<Scuola> getScuoleByRegione(String r) {
		return scuolaRepository.findByRegione(r);
	}

	@Override
	public List<ScuolaDTO> getScuoleByRegioneDTO(String r) {
		return ScuolaMapper.toListDTO(getScuoleByRegione(r));
	}

	private List<Scuola> getScuoleByProvincia(String p) {
		return scuolaRepository.findByProvincia(p);
	}

	@Override
	public List<ScuolaDTO> getScuoleByProvinciaDTO(String p) {
		return ScuolaMapper.toListDTO(getScuoleByProvincia(p));
	}

	private List<Scuola> getScuoleByCitta(String c) {
		return scuolaRepository.findByCitta(c);
	}

	@Override
	public List<ScuolaDTO> getScuoleByCittaDTO(String c) {
		return ScuolaMapper.toListDTO(getScuoleByCitta(c));
	}

	private List<Scuola> getScuoleByRegioneAndProvincia(String r, String p) {
		return scuolaRepository.findByRegioneAndProvincia(r, p);
	}

	@Override
	public List<ScuolaDTO> getScuoleByRegioneAndProvinciaDTO(String r, String p) {
		return ScuolaMapper.toListDTO(getScuoleByRegioneAndProvincia(r, p));
	}

	private List<Scuola> getScuoleByRegioneAndCitta(String r, String c) {
		return scuolaRepository.findByRegioneAndCitta(r, c);
	}

	@Override
	public List<ScuolaDTO> getScuoleByRegioneAndCittaDTO(String r, String c) {
		return ScuolaMapper.toListDTO(getScuoleByRegioneAndCitta(r, c));
	}

	private List<Scuola> getScuoleByProvinciaAndCitta(String p, String c) {
		return scuolaRepository.findByProvinciaAndCitta(p, c);
	}

	@Override
	public List<ScuolaDTO> getScuoleByProvinciaAndCittaDTO(String p, String c) {
		return ScuolaMapper.toListDTO(getScuoleByProvinciaAndCitta(p, c));
	}

}

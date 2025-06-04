package it.registro.scuola.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.model.Scuola;
import it.registro.scuola.repository.ScuolaRepository;
import it.registro.scuola.service.ScuolaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		return toListDTO(getScuole());
	}
	
	private Scuola getScuola(int id) {
		return scuolaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Scuola con id "+ id + " non travata"));
	}
	
	@Override
	public ScuolaDTO getScuolaDTO(int id){
		return toDTO(getScuola(id));
	}
	
	private Scuola addScuola(Scuola s) {
		return scuolaRepository.save(s);
	}
	
	@Override
	public ScuolaDTO addScuolaDTO(ScuolaDTO s) {
		return toDTO(addScuola(toEntity(s)));
	}
	
	public Scuola updateScuola(Scuola s) {
		return scuolaRepository.save(s);		
	}
	
	@Override
	public ScuolaDTO updateScuolaDTO(ScuolaDTO s)  {
		Scuola originalEntity = getScuola(s.getId());
		return toDTO(updateScuola(entityToUp(originalEntity, s)));
	}
	
	private Scuola entityToUp(Scuola oEn, ScuolaDTO newEn) {
		oEn.setNome(newEn.getNome());
		oEn.setTipo(newEn.getTipo());
		oEn.setIndirizzo(newEn.getIndirizzo());
		oEn.setCitta(newEn.getCitta());
		oEn.setProvincia(newEn.getProvincia());
		oEn.setCap(newEn.getCap());
		oEn.setRegione(newEn.getRegione());
		return oEn;
	}
	
	@Override
	public boolean deleteScuola(int id) {
		scuolaRepository.delete(getScuola(id));
		return true;
	}
	
	//filtri per cercare scuole
	private List<Scuola> getScuoleByRegione(String r) {
		return scuolaRepository.findByRegione(r);
	}
	
	@Override
	public List<ScuolaDTO> getScuoleByRegioneDTO(String r) {
		return toListDTO(getScuoleByRegione(r));
	}
	
	private List<Scuola> getScuoleByProvincia(String p) {
		return scuolaRepository.findByProvincia(p);
	}
	
	@Override
	public List<ScuolaDTO> getScuoleByProvinciaDTO(String p) {
		return toListDTO(getScuoleByProvincia(p));
	}
	
	private List<Scuola> getScuoleByCitta(String c) {
		return scuolaRepository.findByCitta(c);
	}
	
	@Override
	public List<ScuolaDTO> getScuoleByCittaDTO(String c) {
		return toListDTO(getScuoleByCitta(c));
	}
	
	private List<Scuola> getScuoleByRegioneAndProvincia(String r, String p) {
		return scuolaRepository.findByRegioneAndProvincia(r, p);
	}
	
	@Override
	public List<ScuolaDTO> getScuoleByRegioneAndProvinciaDTO(String r, String p) {
		return toListDTO(getScuoleByRegioneAndProvincia(r, p));
	}
	
	private List<Scuola> getScuoleByRegioneAndCitta(String r, String c) {
		return scuolaRepository.findByRegioneAndCitta(r, c);
	}
	
	@Override
	public List<ScuolaDTO> getScuoleByRegioneAndCittaDTO(String r, String c) {
		return toListDTO(getScuoleByRegioneAndCitta(r, c));
	}
	
	private List<Scuola> getScuoleByProvinciaAndCitta(String p, String c) {
		return scuolaRepository.findByProvinciaAndCitta(p, c);
	}
	
	@Override
	public List<ScuolaDTO> getScuoleByProvinciaAndCittaDTO(String p, String c) {
		return toListDTO(getScuoleByProvinciaAndCitta(p, c));
	}
	
		
	//DTO helper methods
	private ScuolaDTO toDTO(Scuola s) {
		return new ScuolaDTO(s.getId(), s.getNome(), s.getTipo(), s.getIndirizzo(), s.getCitta(), s.getProvincia(), s.getCap(), s.getRegione());
	}
	private Scuola toEntity(ScuolaDTO s) {
		return new Scuola(s.getNome(), s.getTipo(), s.getIndirizzo(), s.getCitta(), s.getProvincia(), s.getCap(), s.getRegione());
	}
	private List<ScuolaDTO> toListDTO(List<Scuola> listScuole) {
		return listScuole.stream().map(s -> toDTO(s)).collect(Collectors.toCollection(ArrayList::new));
	}
}

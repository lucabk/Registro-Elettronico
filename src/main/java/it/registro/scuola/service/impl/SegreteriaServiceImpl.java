package it.registro.scuola.service.impl;

import java.util.List;

import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.dto.segreteria.AddSegreteriaReqDTO;
import it.registro.scuola.dto.segreteria.AddSegreteriaResDTO;
import it.registro.scuola.dto.utente.UpdateUtentePswDTO;
import it.registro.scuola.mapper.ScuolaMapper;
import it.registro.scuola.model.Utente;
import it.registro.scuola.repository.UtenteRepository;
import it.registro.scuola.utilty.Ruolo;
import it.registro.scuola.validation.SegreteriaInputValidation;
import it.registro.scuola.validation.UtenteInputValidation;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import it.registro.scuola.dto.segreteria.SegreteriaDTO;
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
	private UtenteServiceImpl utenteService;
	private UtenteRepository utenteRepository;

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
	public AddSegreteriaResDTO addSegreteria(AddSegreteriaReqDTO s) {
		SegreteriaInputValidation.addSegreteriaReqDTOValidation(s);
		Scuola scuola = scuolaService.getScuola(s.getScuolaDTO().getId());
		Segreteria entity = SegreteriaMapper.toEntity(s);
		entity.setScuola(scuola);
		Segreteria savedSeg = segreteriaRepository.save(entity);

		Utente newUser = new Utente(s.getUsername(), s.getPassword(), Ruolo.SEG.toString(), savedSeg.getId());
		Utente savedUser = utenteService.addUtente(newUser);

		return new AddSegreteriaResDTO(
				savedUser.getId(),
				savedUser.getUsername(),
				savedSeg.getId(),
				savedSeg.getNome(),
				ScuolaMapper.toDTO(savedSeg.getScuola())
		);
	}

	@Override 
	public void updateSegreteria(SegreteriaDTO s, int id) {
		Segreteria originalEntity = segreteriaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Segreteria con id "+id+" non trovata"));
		Segreteria sToUp = SegreteriaMapper.entityToUp(originalEntity, s);
		if(s.getScuolaDTO() != null && originalEntity.getScuola().getId() != s.getScuolaDTO().getId()) {
			Scuola scuola = scuolaService.getScuola(s.getScuolaDTO().getId());
			sToUp.setScuola(scuola);
		}
		segreteriaRepository.save(sToUp);
	}

	@Override
	public void updateSegreteriaPassword(UpdateUtentePswDTO c, int id) {
		UtenteInputValidation.ValidationUpdateUtentePswDTO(c);
		getSegreteria(id);
		utenteService.upUtentePsw(id, c);
	}

	@Override
	public void deleteSegreteria(int id) {
		segreteriaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Segreteria con id "+id+" non trovata"));
		segreteriaRepository.deleteById(id);
		utenteService.deleteUtente(id); //idRiferimento
	}

	@Override
	public ScuolaDTO getScuolaByUsername(String username) {
		Utente u = utenteRepository.findByUsername(username);
		if(u == null) {
			throw new UsernameNotFoundException("Utente "+username+" non trovato");
		}
		SegreteriaDTO s = getSegreteria(u.getRiferimentoId());
		return  s.getScuolaDTO();
	}
}

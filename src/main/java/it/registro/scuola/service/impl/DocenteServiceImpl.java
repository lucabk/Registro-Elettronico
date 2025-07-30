package it.registro.scuola.service.impl;

import it.registro.scuola.dto.docente.AddDocenteDTO;
import it.registro.scuola.dto.docente.DocenteDTO;
import it.registro.scuola.dto.utente.UpdateUtentePswDTO;
import it.registro.scuola.mapper.DocenteMapper;
import it.registro.scuola.model.Docente;
import it.registro.scuola.model.Utente;
import it.registro.scuola.repository.DocenteRepository;
import it.registro.scuola.service.DocenteService;
import it.registro.scuola.utilty.Ruolo;
import it.registro.scuola.validation.DocenteInputValidation;
import it.registro.scuola.validation.UtenteInputValidation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DocenteServiceImpl implements DocenteService {

    private DocenteRepository docenteRepository;
    private UtenteServiceImpl utenteService;

    @Override
    public DocenteDTO getDocenteDTO(int id) {
        return DocenteMapper.toDTO(docenteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Docente con id "+id+" non trovato")));
    }

    public Docente getDocente(int id){
        return docenteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Docente con id "+id+" non trovato"));
    }

    @Override
    public DocenteDTO addDocente(AddDocenteDTO d) {
        DocenteInputValidation.validationAddDocenteDTO(d);
        Docente entityToSave = DocenteMapper.toEntity(d);
        Docente saved = docenteRepository.save(entityToSave);

        utenteService.addUtente(new Utente(d.getUsername(), d.getPassword(), Ruolo.DOC.toString(), saved.getId()));

        return DocenteMapper.toDTO(saved);
    }

    @Override
    public DocenteDTO updateDocente(DocenteDTO d, int id) {
        Docente originalEntity = docenteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Docente con id "+id+ " non trovato"));
        Docente entityUpdated = DocenteMapper.EntityToUpdate(originalEntity, d);
        return DocenteMapper.toDTO(docenteRepository.save(entityUpdated));
    }

    @Override
    public void udpdatePswDocente(UpdateUtentePswDTO c, int id) {
        UtenteInputValidation.ValidationUpdateUtentePswDTO(c);
        getDocenteDTO(id);
        utenteService.upUtentePsw(id, c);
    }

    @Override
    public void deleteDocente(int id) {
        getDocenteDTO(id);
        docenteRepository.deleteById(id);
        utenteService.deleteUtente(id);
    }
}

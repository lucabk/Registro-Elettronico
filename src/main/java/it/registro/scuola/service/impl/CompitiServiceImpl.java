package it.registro.scuola.service.impl;

import it.registro.scuola.dto.CompitiDTO;
import it.registro.scuola.mapper.CompitiMapper;
import it.registro.scuola.repository.CompitiRepository;
import it.registro.scuola.service.CompitiService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CompitiServiceImpl implements CompitiService {

    private final CompitiRepository compitiRepository;
    private final IncaricoServiceImpl incaricoService;

    @Override
    public CompitiDTO getCompito(int id) {
        return CompitiMapper.toDTO(compitiRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Compito con id "+id+" non trovato")));
    }

    @Override
    public List<CompitiDTO> getCompitiByClasse(int idClasse) {
        return CompitiMapper.toListDTO(compitiRepository.findCompitiByIncarico_Classe_Id(idClasse));
    }

    @Override
    public CompitiDTO addCompiti(CompitiDTO c) {
        if(c.getIncaricoDTO() == null){
            throw new IllegalArgumentException("E' obbligatorio specificare l'insegnamento a cui aggiungere i compiti");
        }
        return CompitiMapper.toDTO(compitiRepository.save(CompitiMapper.toEnitySave(c, incaricoService.getIncaricoModel(c.getIncaricoDTO().getId()))));
    }
}

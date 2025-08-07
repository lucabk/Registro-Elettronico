package it.registro.scuola.service.impl;

import it.registro.scuola.dto.verifica.VerificaDTO;
import it.registro.scuola.mapper.VerificaMapper;
import it.registro.scuola.repository.VerificaRepository;
import it.registro.scuola.service.VerificaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VerificaServiceImpl implements VerificaService {

    private final VerificaRepository verificaRepository;
    private final IncaricoServiceImpl incaricoService;

    @Override
    public VerificaDTO getVerificaDTO(int idVerifica) {
        return VerificaMapper.toDTO(verificaRepository.findById(idVerifica)
                .orElseThrow(()->new EntityNotFoundException("Verifica con id "+idVerifica+" non trovata.")));
    }

    @Override
    public List<VerificaDTO> getVerificheByClasseDTO(int idClasse) {
        return VerificaMapper.toListDTO(verificaRepository.findVerificaByIncarico_Classe_Id(idClasse));
    }

    @Override
    public VerificaDTO addVerficaDTO(VerificaDTO v) {
        if(v.getIncaricoDTO() == null){
            throw new IllegalArgumentException("E' obbligatorio specificare l'insegnamento a cui aggiungere i compiti");
        }
        return VerificaMapper.toDTO(verificaRepository.save(VerificaMapper.toEntity(v, incaricoService.getIncaricoModel(v.getIncaricoDTO().getId()))));
    }
}

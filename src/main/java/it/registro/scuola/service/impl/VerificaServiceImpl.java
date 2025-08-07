package it.registro.scuola.service.impl;

import it.registro.scuola.dto.verifica.VerificaDTO;
import it.registro.scuola.mapper.VerificaMapper;
import it.registro.scuola.repository.VerificaRepository;
import it.registro.scuola.service.VerificaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class VerificaServiceImpl implements VerificaService {

    private final VerificaRepository verificaRepository;

    @Override
    public VerificaDTO getVerificaDTO(int idVerifica) {
        return VerificaMapper.toDTO(verificaRepository.findById(idVerifica)
                .orElseThrow(()->new EntityNotFoundException("Verifica con id "+idVerifica+" non trovata.")));
    }
}

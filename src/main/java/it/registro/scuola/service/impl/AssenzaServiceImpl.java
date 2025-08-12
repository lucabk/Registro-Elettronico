package it.registro.scuola.service.impl;

import it.registro.scuola.dto.assenza.AssenzaDTO;
import it.registro.scuola.mapper.AssenzaMapper;
import it.registro.scuola.repository.AssenzaRepository;
import it.registro.scuola.service.AssenzaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AssenzaServiceImpl implements AssenzaService {
    private final AssenzaRepository assenzaRepository;

    @Override
    public List<AssenzaDTO> getAssenzeByStudente(int idStudente) {
        return AssenzaMapper.toListDTO(assenzaRepository.findAssenzasByStudente_Id(idStudente));
    }
}

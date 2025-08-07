package it.registro.scuola.service;

import it.registro.scuola.dto.verifica.VerificaDTO;

import java.util.List;

public interface VerificaService {
    VerificaDTO getVerificaDTO(int idVerifica);
    List<VerificaDTO> getVerificheByClasseDTO(int idClasse);
    VerificaDTO addVerficaDTO(VerificaDTO v);
    VerificaDTO updateVerificaDTO(VerificaDTO v, int idVerifica);
}

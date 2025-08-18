package it.registro.scuola.service;

import it.registro.scuola.dto.compiti.CompitiDTO;
import it.registro.scuola.dto.compiti.CompitoUpdateDTO;

import java.util.List;

public interface CompitiService {
    CompitiDTO getCompitoDTO(int id);
    List<CompitiDTO> getCompitiByClasse(int idClasse);
    List<CompitiDTO> getCompitiByDocente(int idDocente);
    CompitiDTO addCompiti(CompitiDTO c);
    CompitiDTO updateCompiti(CompitoUpdateDTO c, int idCompiti);
    void deleteCompiti(int id);
}

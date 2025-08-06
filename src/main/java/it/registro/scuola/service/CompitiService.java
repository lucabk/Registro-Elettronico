package it.registro.scuola.service;

import it.registro.scuola.dto.CompitiDTO;

import java.util.List;

public interface CompitiService {
    CompitiDTO getCompito(int id);
    List<CompitiDTO> getCompitiByClasse(int idClasse);
    CompitiDTO addCompiti(CompitiDTO c);
}

package it.registro.scuola.repository;

import it.registro.scuola.model.Compiti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompitiRepository extends JpaRepository<Compiti, Integer> {
    List<Compiti> findCompitiByIncarico_Classe_Id(int classeId);
    List<Compiti> findCompitiByIncarico_Docente_Id(int idDocente);
}

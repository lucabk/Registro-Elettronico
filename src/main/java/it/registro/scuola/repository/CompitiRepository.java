package it.registro.scuola.repository;

import it.registro.scuola.model.Compiti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompitiRepository extends JpaRepository<Compiti, Integer> {
}

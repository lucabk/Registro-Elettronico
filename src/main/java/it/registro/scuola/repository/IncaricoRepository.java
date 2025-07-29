package it.registro.scuola.repository;

import it.registro.scuola.model.Incarico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncaricoRepository extends JpaRepository<Incarico, Integer> {
}

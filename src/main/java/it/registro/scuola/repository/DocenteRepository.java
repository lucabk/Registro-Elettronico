package it.registro.scuola.repository;

import it.registro.scuola.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {
}

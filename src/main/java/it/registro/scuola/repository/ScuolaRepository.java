package it.registro.scuola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.registro.scuola.model.Scuola;

public interface ScuolaRepository extends JpaRepository<Scuola, Integer>{

}

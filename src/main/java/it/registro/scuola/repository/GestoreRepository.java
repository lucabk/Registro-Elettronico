package it.registro.scuola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.registro.scuola.model.Gestore;

public interface GestoreRepository extends JpaRepository<Gestore, Integer>{
	
}

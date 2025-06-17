package it.registro.scuola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.registro.scuola.model.Segreteria;
import java.util.*;


public interface SegreteriaRepository extends JpaRepository<Segreteria, Integer>{
	List<Segreteria> findByScuolaId(int idScuola);
}

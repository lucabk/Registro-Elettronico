package it.registro.scuola.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import it.registro.scuola.model.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Integer>{
	List<Classe> findByScuolaId(int idScuola); 
}

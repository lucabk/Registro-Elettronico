package it.registro.scuola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.registro.scuola.model.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Integer>{

}

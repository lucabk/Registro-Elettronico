package it.registro.scuola.repository;

import it.registro.scuola.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {
    List<Studente> findByClasseId(int idClasse);
    List<Studente> findByScuolaId(int idScuola);
}

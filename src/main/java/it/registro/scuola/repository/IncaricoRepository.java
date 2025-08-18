package it.registro.scuola.repository;

import it.registro.scuola.model.Incarico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IncaricoRepository extends JpaRepository<Incarico, Integer> {
    List<Incarico> findByScuolaId(Integer idScuola);
    List<Incarico> findByClasseId(Integer idClasse);
    List<Incarico> findByDocenteId(Integer idDocente);
}

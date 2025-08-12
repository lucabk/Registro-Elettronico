package it.registro.scuola.repository;

import it.registro.scuola.model.Assenza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssenzaRepository extends JpaRepository<Assenza, Integer> {
    List<Assenza> findAssenzasByStudente_Id(int idStudente);
}

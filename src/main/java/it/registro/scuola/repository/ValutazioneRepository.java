package it.registro.scuola.repository;

import it.registro.scuola.model.Valutazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValutazioneRepository extends JpaRepository<Valutazione, Integer> {
}

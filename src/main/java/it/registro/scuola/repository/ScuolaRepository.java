package it.registro.scuola.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import it.registro.scuola.model.Scuola;

public interface ScuolaRepository extends JpaRepository<Scuola, Integer>{
	List<Scuola> findByRegione(String regione);
	List<Scuola> findByProvincia(String provincia);
	List<Scuola> findByCitta(String citta);
	
	List<Scuola> findByRegioneAndProvincia(String regione, String provincia);
	List<Scuola> findByRegioneAndCitta(String regione, String citta);
	List<Scuola> findByProvinciaAndCitta(String provincia, String citta);
}

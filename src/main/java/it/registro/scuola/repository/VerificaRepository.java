package it.registro.scuola.repository;

import it.registro.scuola.model.Verifica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerificaRepository extends JpaRepository<Verifica, Integer> {
    List<Verifica> findVerificaByIncarico_Classe_Id(int idClasse);
}

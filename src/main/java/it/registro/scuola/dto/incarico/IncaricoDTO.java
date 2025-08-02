package it.registro.scuola.dto.incarico;

import it.registro.scuola.dto.ClasseDTO;
import it.registro.scuola.dto.MateriaDTO;
import it.registro.scuola.dto.ScuolaDTO;
import it.registro.scuola.dto.docente.DocenteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IncaricoDTO {
    private int id;
    private ScuolaDTO scuolaDTO;
    private ClasseDTO classeDTO;
    private DocenteDTO docenteDTO;
    private MateriaDTO materiaDTO;
    private String programma;
}

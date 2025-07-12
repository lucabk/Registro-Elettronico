package it.registro.scuola.dto.segreteria;

import it.registro.scuola.dto.ScuolaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddSegreteriaResDTO {
    private int idUtente;
    private String username;
    private int idSegreteria;
    private String nome;
    private ScuolaDTO scuolaDTO;
}

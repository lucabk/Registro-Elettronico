package it.registro.scuola.dto.register;

import it.registro.scuola.dto.ScuolaDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

package it.registro.scuola.dto;

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
public class MateriaDTO {

    private int id;

    @NotBlank
    @Size(min=1, max=50)
    private String nome;

    @NotBlank
    @Size(min=1, max=10)
    private String codice;

    @NotBlank
    @Size(min=1, max = 65535)
    private String programma;
}

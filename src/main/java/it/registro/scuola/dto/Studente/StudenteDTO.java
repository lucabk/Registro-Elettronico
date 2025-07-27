package it.registro.scuola.dto.Studente;

import it.registro.scuola.dto.ClasseDTO;
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
public class StudenteDTO {
    private int id;

    @NotBlank
    @Size(min=1, max=50)
    private String nome;

    @NotBlank
    @Size(min=1, max=50)
    private String cognome;

    @NotBlank
    @Size(min=1, max=50)
    private String email;

    @NotBlank
    @Size(min=1, max=15)
    private String numero;

    @NotBlank
    @Size(min=1, max=16)
    private String codiceFiscale;

    @NotBlank
    @Size(min=1, max=100)
    private String indirizzo;

    @NotBlank
    @Size(min=1, max=50)
    private String citta;

    @NotBlank
    @Size(min=1, max=10)
    private String provincia;

    @NotBlank
    @Size(min=1, max=5)
    private String cap;

    private ScuolaDTO scuolaDTO;

    private ClasseDTO classeDTO;

}

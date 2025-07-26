package it.registro.scuola.dto;

import jakarta.persistence.Column;
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
    private String nome;
    private String cognome;
    private String email;
    private String numero;
    private String codiceFiscale;
    private String indirizzo;
    private String citta;
    private String provincia;
    private String cap;
    private ScuolaDTO scuolaDTO;
    private ClasseDTO classeDTO;
}

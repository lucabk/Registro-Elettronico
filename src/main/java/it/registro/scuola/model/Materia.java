package it.registro.scuola.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "materia")
@NoArgsConstructor
@Getter
@Setter
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codice")
    private String codice;

    @Column(name = "data_inserimento", insertable = false, updatable = false)
    private Date dataInserimento;

    @Column(name = "data_aggiornamento", insertable = false, updatable = false)
    private Date dataAggiornamento;

    @OneToMany(mappedBy = "materia")
    private Set<Incarico> incarichi;

    public Materia(String nome, String codice) {
        this.nome = nome;
        this.codice = codice;
    }
}

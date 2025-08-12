package it.registro.scuola.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "assenza")
@NoArgsConstructor
@Getter
@Setter
public class Assenza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assenza")
    private int id;

    @Column(name = "giustificata")
    private boolean giustificata;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "data_inserimento", insertable = false, updatable = false)
    private Date dataInserimento;

    @Column(name = "data_aggiornamento", insertable = false, updatable = false)
    private Date dataAggiornamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;

    public Assenza(boolean giustificata, String tipo) {
        this.giustificata = giustificata;
        this.tipo = tipo;
    }
}

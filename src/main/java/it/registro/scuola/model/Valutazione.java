package it.registro.scuola.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "valutazione")
@NoArgsConstructor
@Getter
@Setter
public class Valutazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valutazione")
    private int id;

    @Column(name = "voto")
    private int voto;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "data_inserimento", insertable = false, updatable = false)
    private Date dataInserimento;

    @Column(name = "data_aggiornamento", insertable = false, updatable = false)
    private Date dataAggiornamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_incarico", nullable = false)
    private Incarico incarico;

    public Valutazione(int voto, String tipo) {
        this.voto = voto;
        this.tipo = tipo;
    }
}

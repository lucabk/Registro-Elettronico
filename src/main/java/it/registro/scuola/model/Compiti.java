package it.registro.scuola.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "compiti")
@NoArgsConstructor
@Getter
@Setter
public class Compiti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compito")
    private int id;

    @Column(name = "esercizi")
    private String esercizi;

    @Column(name = "data_consegna")
    private LocalDate dataConsegna;

    @Column(name = "data_inserimento", insertable = false, updatable = false)
    private Date dataInserimento;

    @Column(name = "data_aggiornamento", insertable = false, updatable = false)
    private Date dataAggiornamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_incarico", nullable = false)
    private Incarico incarico;

    public Compiti(String esercizi, LocalDate dataConsegna) {
        this.esercizi = esercizi;
        this.dataConsegna = dataConsegna;
    }
}

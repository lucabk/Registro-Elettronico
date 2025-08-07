package it.registro.scuola.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "verifica")
@NoArgsConstructor
@Getter
@Setter
public class Verifica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_verifica")
    private int id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "argomenti")
    private String argomenti;

    @Column(name = "data_verifica")
    private LocalDate dataVerifica;

    @Column(name = "data_inserimento", insertable = false, updatable = false)
    private Date dataInserimento;

    @Column(name = "data_aggiornamento", insertable = false, updatable = false)
    private Date dataAggiornamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_incarico", nullable = false)
    private Incarico incarico;

    public Verifica(String tipo, LocalDate dataVerifica, String argomenti) {
        this.tipo = tipo;
        this.dataVerifica = dataVerifica;
        this.argomenti = argomenti;
    }
}

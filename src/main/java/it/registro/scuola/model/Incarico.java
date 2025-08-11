package it.registro.scuola.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "incarico")
@NoArgsConstructor
@Getter
@Setter
public class Incarico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incarico")
    private int id;

    @Column(name = "data_inserimento", insertable = false, updatable = false)
    private Date dataInserimento;

    @Column(name = "data_aggiornamento", insertable = false, updatable = false)
    private Date dataAggiornamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_scuola", nullable = false)
    private Scuola scuola;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_classe", nullable = false)
    private Classe classe;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_materia", nullable = false)
    private Materia materia;

    @OneToMany(mappedBy = "incarico")
    private Set<Compiti> compiti;

    @OneToMany(mappedBy = "incarico")
    private Set<Verifica> verifiche;

    @OneToMany(mappedBy = "incarico")
    private Set<Valutazione> valutazioni;

    @Column(name = "programma")
    private String programma;
}

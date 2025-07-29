package it.registro.scuola.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classe")
@NoArgsConstructor
@Getter
@Setter
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_classe")
	private int id;

	@Column(name = "grado")
	private int grado;

	@Column(name = "lettera")
	private String lettera;

	@Column(name = "anno_scolastico")
	private String annoScolastico;

	@Column(name = "data_inserimento", insertable = false, updatable = false)
	private Date dataInserimento;

	@Column(name = "data_aggiornamento", insertable = false, updatable = false)
	private Date dataAggiornamento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_scuola", nullable = false)
	private Scuola scuola;

	@OneToMany(mappedBy = "classe")
	private Set<Studente> studenti;

	@OneToMany(mappedBy = "classe")
	private Set<Incarico> incarichi;

	public Classe(int grado, String lettera, String annoScolastico) {
		super();
		this.grado = grado;
		this.lettera = lettera;
		this.annoScolastico = annoScolastico;
	}

}

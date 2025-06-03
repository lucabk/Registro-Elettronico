package it.registro.scuola.model;

import java.util.Date;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Scuola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scuola")
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "indirizzo")
	private String indirizzo;

	@Column(name = "citta")
	private String citta;

	@Column(name = "provincia")
	private String provincia;

	@Column(name = "cap")
	private String cap;

	@Column(name = "regione")
	private String regione;

	@Column(name = "data_inserimento")
	private Date dataInserimento;

	@Column(name = "data_aggiornamento")
	private Date dataAggiornamento;

	@OneToMany(mappedBy = "scuola")
	private Set<Classe> classi;

	public Scuola(String nome, String tipo, String indirizzo, String citta, String provincia, String cap,
			String regione) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.cap = cap;
		this.regione = regione;
	}

}

package it.registro.scuola.model;

import java.util.Date;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table
public class Scuola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scuola")
	private int id_scuola;

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
	private Date data_inserimento;

	@Column(name = "data_aggiornamento")
	private Date data_aggiornamento;

	@OneToMany(mappedBy = "scuola")
	private Set<Classe> classi;

	public Scuola() {
		super();
	}

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

	public int getId_scuola() {
		return id_scuola;
	}

	public void setId_scuola(int id_scuola) {
		this.id_scuola = id_scuola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public Date getData_inserimento() {
		return data_inserimento;
	}

	public void setData_inserimento(Date data_inserimento) {
		this.data_inserimento = data_inserimento;
	}

	public Date getData_aggiornamento() {
		return data_aggiornamento;
	}

	public void setData_aggiornamento(Date data_aggiornamento) {
		this.data_aggiornamento = data_aggiornamento;
	}

	public Set<Classe> getClassi() {
		return classi;
	}

	public void setClassi(Set<Classe> classi) {
		this.classi = classi;
	}

}

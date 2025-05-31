package it.registro.scuola.dto;

import java.util.Date;
import java.util.Set;

import it.registro.scuola.model.Classe;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class ScuolaDTO {
	private int id_scuola;
	private String nome;
	private String tipo;
	private String indirizzo;
	private String citta;
	private String provincia;
	private String cap;
	private String regione;
	
	public ScuolaDTO() {
		super();
	}

	public ScuolaDTO(int id_scuola, String nome, String tipo, String indirizzo, String citta, String provincia,
			String cap, String regione) {
		super();
		this.id_scuola = id_scuola;
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


}

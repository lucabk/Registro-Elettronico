package it.registro.scuola.dto;

import java.io.Serializable;
import java.util.Date;

import it.registro.scuola.model.Scuola;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ClasseDTO implements Serializable {

	private static final long serialVersionUID = -8719279470814516505L;

	private int id_classe;
	private int grado;
	private String lettera;
	private String annoScolastico;
	private String nomeScuola;
	private String tipoScuola;
	private String cittaScuola;

	public ClasseDTO() {
		super();
	}

	public ClasseDTO(int id_classe, int grado, String lettera, String annoScolastico, String nomeScuola,
			String tipoScuola, String cittaScuola) {
		super();
		this.id_classe = id_classe;
		this.grado = grado;
		this.lettera = lettera;
		this.annoScolastico = annoScolastico;
		this.nomeScuola = nomeScuola;
		this.tipoScuola = tipoScuola;
		this.cittaScuola = cittaScuola;
	}

	public int getId_classe() {
		return id_classe;
	}

	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public String getLettera() {
		return lettera;
	}

	public void setLettera(String lettera) {
		this.lettera = lettera;
	}

	public String getAnnoScolastico() {
		return annoScolastico;
	}

	public void setAnnoScolastico(String annoScolastico) {
		this.annoScolastico = annoScolastico;
	}

	public String getNomeScuola() {
		return nomeScuola;
	}

	public void setNomeScuola(String nomeScuola) {
		this.nomeScuola = nomeScuola;
	}

	public String getTipoScuola() {
		return tipoScuola;
	}

	public void setTipoScuola(String tipoScuola) {
		this.tipoScuola = tipoScuola;
	}

	public String getCittaScuola() {
		return cittaScuola;
	}

	public void setCittaScuola(String cittaScuola) {
		this.cittaScuola = cittaScuola;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

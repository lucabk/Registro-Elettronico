package it.registro.scuola.model;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "classe")
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_classe")
	private int id_classe;

	@Column(name = "grado")
	private int grado;

	@Column(name = "lettera")
	private String lettera;

	@Column(name = "anno_scolastico")
	private String annoScolastico;

	@Column(name = "data_inserimento")
	private Date data_inserimento;

	@Column(name = "data_aggiornamento")
	private Date data_aggiornamento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_scuola", nullable = false)
	private Scuola scuola;

	public Classe() {
		super();
	}

	public Classe(int grado, String lettera, String annoScolastico, Date data_inserimento, Date data_aggiornamento) {
		super();
		this.grado = grado;
		this.lettera = lettera;
		this.annoScolastico = annoScolastico;
		this.data_inserimento = data_inserimento;
		this.data_aggiornamento = data_aggiornamento;
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

	public Scuola getScuola() {
		return scuola;
	}

	public void setScuola(Scuola scuola) {
		this.scuola = scuola;
	}

	
}

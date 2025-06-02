package it.registro.scuola.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ScuolaDTO implements Serializable {
	private static final long serialVersionUID = -1431517914420872478L;

	private int id;
	private String nome;
	private String tipo;
	private String indirizzo;
	private String citta;
	private String provincia;
	private String cap;
	private String regione;

	public ScuolaDTO(int id, String nome, String tipo, String indirizzo, String citta, String provincia, String cap,
			String regione) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.cap = cap;
		this.regione = regione;
	}

}

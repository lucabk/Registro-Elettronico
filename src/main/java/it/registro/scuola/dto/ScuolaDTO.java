package it.registro.scuola.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class ScuolaDTO implements Serializable {
	private static final long serialVersionUID = -1431517914420872478L;

	private int id;
	
	@NotBlank
	@Size(min=5, max=50)
	private String nome;
	
	@NotBlank
	@Size(min=5, max=50)
	private String tipo;
	
	@NotBlank
	@Size(min=2, max=100)
	private String indirizzo;
	
	@NotBlank
	@Size(min=2, max=50)
	private String citta;
	
	@NotBlank
	@Size(min=2, max=2)
	private String provincia;
	
	@NotBlank
	@Size(min=5, max=5)
	@Pattern(regexp = "\\d{5}", message = "Il CAP deve avere 5 cifre")
	private String cap;
	
	@NotBlank
	@Size(min=2, max=50)
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

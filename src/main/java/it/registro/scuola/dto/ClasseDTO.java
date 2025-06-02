package it.registro.scuola.dto;

import java.io.Serializable;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Setter
public class ClasseDTO implements Serializable {
	private static final long serialVersionUID = -8719279470814516505L;

	private int id;
	private int grado;
	private String lettera;
	private String annoScolastico;
	private ScuolaDTO scuolaDTO;

	public ClasseDTO(int id, int grado, String lettera, String annoScolastico, ScuolaDTO scuolaDTO) {
		super();
		this.id = id;
		this.grado = grado;
		this.lettera = lettera;
		this.annoScolastico = annoScolastico;
		this.scuolaDTO = scuolaDTO;
	}

}

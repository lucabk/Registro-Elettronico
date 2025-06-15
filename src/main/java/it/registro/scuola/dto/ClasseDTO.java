package it.registro.scuola.dto;

import java.io.Serializable;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClasseDTO implements Serializable {
	private static final long serialVersionUID = -8719279470814516505L;

	private int id;
	
	@Min(1)
	@Max(5)
	private int grado;
	
	@NotBlank
	@Size(min=1, max=5)
	private String lettera;
	
	@NotBlank
	@Size(min=4, max=10)
	private String annoScolastico;
	
	private ScuolaDTO scuolaDTO;

}

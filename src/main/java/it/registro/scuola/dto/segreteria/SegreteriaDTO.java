package it.registro.scuola.dto.segreteria;

import it.registro.scuola.dto.ScuolaDTO;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SegreteriaDTO {
	
	private int id;
	
	@NotBlank
	@Size(min=5, max=100)
	private String nome;
	
	private ScuolaDTO scuolaDTO;
}

package it.registro.scuola.dto;


import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GestoreDTO {
	
	private int id;
	
	@NotBlank
	@Size(min=1, max=50)
	private String username;
	
	@NotBlank
	@Size(min=6, max=255)
	private String psw;
}

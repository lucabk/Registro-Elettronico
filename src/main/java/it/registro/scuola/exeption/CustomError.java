package it.registro.scuola.exeption;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomError {
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;

}

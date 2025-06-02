package it.registro.scuola.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new CustomError(HttpStatus.NOT_FOUND.value(), "NOT FOUND", ex.getMessage())
		);
	}
}

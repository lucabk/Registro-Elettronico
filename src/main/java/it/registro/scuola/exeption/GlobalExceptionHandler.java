package it.registro.scuola.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<CustomError> handleEntityNotFound(EntityNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new CustomError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "NOT FOUND", ex.getMessage())
		);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomError> handleValidationException(MethodArgumentNotValidException ex) {
		StringBuilder message = new StringBuilder("Errore di validazione:\n");

		ex.getBindingResult().getFieldErrors().forEach(error -> {
			message.append("- ").append(error.getField())
			       .append(": ").append(error.getDefaultMessage()).append("\n");
		});

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new CustomError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "VALIDATION ERROR", message.toString()));
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<CustomError> handleSqlConstraintViolation(SQLIntegrityConstraintViolationException ex) {
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(new CustomError(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				"SQL CONSTRAINT VIOLATION",
				ex.getMessage()
			));
	}
}

package it.registro.scuola.dto.assenza;

import it.registro.scuola.dto.Studente.StudenteDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AssenzaDTO {
    private int id;

    private Boolean giustificata;

    @Pattern(regexp = "^(parziale|intera)$", message = "Il tipo deve essere 'parziale' oppure 'intera'")
    @NotBlank
    private String tipo;

    private StudenteDTO studenteDTO;
}

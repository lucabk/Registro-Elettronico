package it.registro.scuola.dto.verifica;

import it.registro.scuola.dto.incarico.IncaricoDTO;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VerificaDTO {
    private int id;

    @Pattern(regexp = "^(scritto|orale)$", message = "Il tipo deve essere 'scritto' oppure 'orale'")
    @NotBlank
    private String tipo;

    @NotBlank
    @Size(min=1, max=65535)
    private String argomenti;

    @NotNull
    @Future(message = "La data deve essere nel futuro")
    private LocalDate dataVerifica;

    private IncaricoDTO incaricoDTO;
}

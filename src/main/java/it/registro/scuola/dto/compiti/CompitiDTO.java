package it.registro.scuola.dto.compiti;

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
public class CompitiDTO {
    private int id;

    @NotBlank
    @Size(min=1, max=65535)
    private String esercizi;

    @NotNull
    @Future(message = "La data deve essere nel futuro")
    private LocalDate dataConsegna;

    private IncaricoDTO incaricoDTO;
}

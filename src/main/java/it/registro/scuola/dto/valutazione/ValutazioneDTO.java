package it.registro.scuola.dto.valutazione;

import it.registro.scuola.dto.Studente.StudenteDTO;
import it.registro.scuola.dto.incarico.IncaricoDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ValutazioneDTO {
    private int id;

    @NotNull
    @Size(min=1, max=10 )
    private int voto;

    @Pattern(regexp = "^(scritto|orale)$", message = "Il tipo deve essere 'scritto' oppure 'orale'")
    @NotBlank
    private String tipo;

    private StudenteDTO studenteDTO;

    private IncaricoDTO incaricoDTO;

}

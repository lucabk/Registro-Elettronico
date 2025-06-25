package it.registro.scuola.dto.segreteria;

import it.registro.scuola.dto.ScuolaDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddSegreteriaReqDTO {

    @NotBlank
    @Size(min=5, max=100)
    private String nome;

    @NotBlank
    @Size(min=1, max=50)
    private String username;

    @NotBlank
    @Size(min=4, max=50)
    private String password;

    private ScuolaDTO scuolaDTO;
}

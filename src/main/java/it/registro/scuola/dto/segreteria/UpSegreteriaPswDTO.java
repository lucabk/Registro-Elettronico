package it.registro.scuola.dto.segreteria;

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
public class UpSegreteriaPswDTO {

    @NotBlank
    @Size(min=4, max=50)
    private String password;
}

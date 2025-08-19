package it.registro.scuola.dto.assenza;

import it.registro.scuola.dto.Studente.StudenteDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class AssenzaResDTO extends AssenzaDTO{
    private Date dataInserimento;

    public AssenzaResDTO(int id, boolean giustificata, String tipo, StudenteDTO dto, Date dataInserimento) {
        super(id, giustificata, tipo, dto);
        this.dataInserimento = dataInserimento;
    }
}

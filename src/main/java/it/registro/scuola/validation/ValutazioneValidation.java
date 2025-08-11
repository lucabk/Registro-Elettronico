package it.registro.scuola.validation;

import it.registro.scuola.dto.valutazione.ValutazioneDTO;

public class ValutazioneValidation {
    public static void addValutazioneDTOValidation(ValutazioneDTO v){
        if(v.getIncaricoDTO() == null || v.getIncaricoDTO().getId() <= 0 ){
            throw new IllegalArgumentException("E' obbligatorio specificare l'insegnamento a cui aggiungere il voto");
        } else if (v.getStudenteDTO() == null || v.getStudenteDTO().getId() <= 0) {
            throw new IllegalArgumentException("E' obbligatorio specificare lo studente a cui aggiungere il voto");
        }
    }
}

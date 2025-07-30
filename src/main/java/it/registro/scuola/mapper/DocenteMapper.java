package it.registro.scuola.mapper;

import it.registro.scuola.dto.docente.AddDocenteDTO;
import it.registro.scuola.dto.docente.DocenteDTO;
import it.registro.scuola.model.Docente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DocenteMapper {
    public static DocenteDTO toDTO(Docente d) {
        return new DocenteDTO(d.getId(), d.getNome(), d.getCognome(), d.getEmail(), d.getNumero(), d.getCodiceFiscale(),
                d.getIndirizzo(), d.getCitta(), d.getProvincia(), d.getCap(), d.getIstruzione());
    }

    public static Docente toEntity(AddDocenteDTO d) {
        return new Docente(d.getNome(), d.getCognome(), d.getEmail(), d.getNumero(), d.getCodiceFiscale(),
                d.getIndirizzo(), d.getCitta(), d.getProvincia(), d.getCap(), d.getIstruzione());
    }

    public static Docente EntityToUpdate(Docente originalEntity, DocenteDTO d) {
        originalEntity.setNome(d.getNome());
        originalEntity.setCognome(d.getCognome());
        originalEntity.setEmail(d.getEmail());
        originalEntity.setNumero(d.getNumero());
        originalEntity.setCodiceFiscale(d.getCodiceFiscale());
        originalEntity.setIndirizzo(d.getIndirizzo());
        originalEntity.setCitta(d.getCitta());
        originalEntity.setProvincia(d.getProvincia());
        originalEntity.setCap(d.getCap());
        originalEntity.setIstruzione(d.getIstruzione());
        return originalEntity;
    }

    public static List<DocenteDTO> toDTOList(List<Docente> d) {
        return d.stream().map(DocenteMapper::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }
}

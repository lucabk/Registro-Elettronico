package it.registro.scuola.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="gestore")
@NoArgsConstructor
@Getter
@Setter
public class Gestore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gestore")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "psw")
	private String psw;
	

	@Column(name = "data_inserimento", insertable = false, updatable = false)
	private Date dataInserimento;

	@Column(name = "data_aggiornamento", insertable = false, updatable = false)
	private Date dataAggiornamento;

	
}

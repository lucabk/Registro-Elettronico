package it.registro.scuola.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "segreteria")
@NoArgsConstructor
@Getter
@Setter
public class Segreteria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_segreteria")
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "data_inserimento", insertable = false, updatable = false)
	private Date dataInserimento;

	@Column(name = "data_aggiornamento", insertable = false, updatable = false)
	private Date dataAggiornamento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_scuola", nullable = false)
	private Scuola scuola;

	public Segreteria(String nome) {
		super();
		this.nome = nome;
	}

}

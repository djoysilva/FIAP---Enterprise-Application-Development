package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CAMPEONATO")
@SequenceGenerator(allocationSize = 1, name = "seqCampeonato", sequenceName = "SQ_TB_CAMPEONATO")
public class Campeonato {

	@Id
	@Column(name = "CD_CAMPEONATO", nullable = false)
	@GeneratedValue(generator = "seqCampeonato", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_CAMPEONATO")
	private String nome;
}

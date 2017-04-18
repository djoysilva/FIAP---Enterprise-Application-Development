package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_JOGADOR")
@SequenceGenerator(allocationSize = 1, name = "seqJogador", sequenceName = "SQ_TB_JOGADOR")
public class Jogador {

	@Id
	@Column(name = "CD_JOGADOR", nullable = false)
	@GeneratedValue(generator = "seqJogador", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_JOGADOR")
	private String nome;
	
	@ManyToOne
	@Column(name = "CD_TIME")
	private Time time;
}

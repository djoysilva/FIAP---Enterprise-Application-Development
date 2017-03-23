package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqCampeonato", sequenceName="SQ_TB_CAMPEONATO", allocationSize=1)
@Table(name = "TB_CAMPEONATO")
public class Campeonato {
	
	@Id
	@Column(name="CD_CAMPEONATO", nullable=false)
	private int codigo;
	
	@Column(name="NM_CAMPEONATO")
	private String nome;
	
}
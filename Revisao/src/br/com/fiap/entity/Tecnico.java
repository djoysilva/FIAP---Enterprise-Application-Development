package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TECNICO")
@SequenceGenerator(allocationSize = 1, name = "seqTecnico", sequenceName = "SQ_TB_TECNICO")
public class Tecnico {

	@Id
	@Column(name = "CD_TECNICO", nullable = false)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seqTecnico")
	private int codigo;
	
	@Column(name = "NM_TECNICO")
	private String nome;
}

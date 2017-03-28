package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqTecnico", sequenceName="SQ_TB_TECNICO", allocationSize=1)
@Table(name = "TB_TECNICO")
public class Tecnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqTecnico")
	@Column(name="CD_TECNICO", nullable=false)
	private int codigo;
	
	@Column(name="NM_TECNICO")
	private String nome;
	
	@OneToOne(mappedBy="tecnico")
	private Time time;

	public Tecnico() {
		super();
	}

	public Tecnico(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	
}

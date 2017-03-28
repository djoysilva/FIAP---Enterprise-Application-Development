package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy="campeonatos")
	private List<Time> time;

	public Campeonato() {
		super();
	}

	public Campeonato(int codigo, String nome) {
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

	public List<Time> getTime() {
		return time;
	}

	public void setTime(List<Time> time) {
		this.time = time;
	}
	
	
}
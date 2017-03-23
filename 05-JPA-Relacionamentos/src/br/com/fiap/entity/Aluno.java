package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name="seqAluno", sequenceName="SQ_TB_ALUNO", allocationSize=1)
public class Aluno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAluno")
	private int rm;
	
	@Column(name="NM_ALUNO", nullable=false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="CD_GRUPOs")
	private GrupoAm grupo;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="TB_ALUNO_PROFESSOR", joinColumns = @JoinColumn(name="RM"), inverseJoinColumns= @JoinColumn(name="CD_PROFESSOR"))
	private List<Professor> professor;
	
	public Aluno() {
		super();
	}

	public Aluno(int rm, String nome) {
		super();
		this.rm = rm;
		this.nome = nome;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public GrupoAm getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAm grupoAm) {
		this.grupo = grupoAm;
	}
	
	public List<Professor> getProfessor() {
		return professor;
	}

	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}
}

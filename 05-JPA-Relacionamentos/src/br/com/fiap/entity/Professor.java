package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_PROFESSOR")
@SequenceGenerator(name = "seqProfessor", sequenceName = "SQ_TB_PROFESSOR", allocationSize = 1)
public class Professor {
	@Id
	@Column(name = "CD_PROFESSOR")
	@GeneratedValue(generator = "seqProfessor", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_PROFESSOR")
	private String nome;
	
	@Column(name = "DT_ADMISSAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataAdmissao;
	
	@ManyToMany(mappedBy = "professores", cascade = CascadeType.PERSIST)
	private List<Aluno> alunos;

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

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Professor(int codigo, String nome, Calendar dataAdmissao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
	}

	public Professor() {
		super();
	}

}

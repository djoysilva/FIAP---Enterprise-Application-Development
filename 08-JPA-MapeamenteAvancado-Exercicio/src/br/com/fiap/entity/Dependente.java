package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_DEPENDENTE")
@IdClass(DependentePK.class)
public class Dependente {
	
	@Id
	@Column(name="CD_PRETENDENTE")
	@SequenceGenerator(name= "seqDependente", sequenceName = "SEQ_DEPENDENTE" ,allocationSize = 1)
	@GeneratedValue(generator="seqDependente", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CD_FUNCIONARIO")
	private Funcionario funcionario;
	
	@Column(name="NM_DEPENDENTE", nullable=false)
	private String nome;

	public Dependente() {
		super();
	}

	public Dependente(int codigo, Funcionario funcionario, String nome) {
		super();
		this.codigo = codigo;
		this.funcionario = funcionario;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

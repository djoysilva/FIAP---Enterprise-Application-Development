package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqExemplar", sequenceName="SEQ_TB_EXEMPLAR", allocationSize=1)
public class Exemplar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqExemplar")
	@Column(nullable=false)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Calendar data_aquisicao;
	
	@Column(nullable=false)
	private Situacao situacao;
	
	@ManyToOne
	@JoinColumn(name="isbn")
	private Livro livro_isbn;
	
	@ManyToMany
	@JoinTable(name="Emprestimo_exemplar", joinColumns = {@JoinColumn(name="id")},
	inverseJoinColumns = {@JoinColumn(name="id")})
	private List<Emprestimo> emprestimo;

	public Exemplar() {
		super();
	}

	public Exemplar(int id, Calendar data_aquisicao, Situacao situacao) {
		super();
		this.id = id;
		this.data_aquisicao = data_aquisicao;
		this.situacao = situacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData_aquisicao() {
		return data_aquisicao;
	}

	public void setData_aquisicao(Calendar data_aquisicao) {
		this.data_aquisicao = data_aquisicao;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public Livro getLivro() {
		return livro_isbn;
	}

	public void setLivro(Livro livro_isbn) {
		this.livro_isbn = livro_isbn;
	}

	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}


}

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqEmprestimo", sequenceName="SEQ_TB_EMPRESTIMO", allocationSize=1)
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEmprestimo")
	@Column(nullable=false)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Calendar data_emprestimo;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar data_retorno;
	
	@ManyToMany
	@JoinTable(name="Emprestimo_exemplar", joinColumns = {@JoinColumn(name="id")},
	inverseJoinColumns = {@JoinColumn(name="id")})
	private List<Exemplar> Exemplar;
	
	@OneToMany
	@JoinColumn(name = "id")
	private Usuario id_usuario;
	
	public Emprestimo() {
		super();
	}

	public Emprestimo(int id, Calendar data_emprestimo, Calendar data_retorno) {
		super();
		this.id = id;
		this.data_emprestimo = data_emprestimo;
		this.data_retorno = data_retorno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData_emprestimo() {
		return data_emprestimo;
	}

	public void setData_emprestimo(Calendar data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}

	public Calendar getData_retorno() {
		return data_retorno;
	}

	public void setData_retorno(Calendar data_retorno) {
		this.data_retorno = data_retorno;
	}
	
	public List<Exemplar> getExemplar() {
		return Exemplar;
	}

	public void setExemplar(List<Exemplar> exemplar) {
		Exemplar = exemplar;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	
}

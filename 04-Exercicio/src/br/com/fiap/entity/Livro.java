package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqLivro",sequenceName="SEQ_TB_LIVRO", allocationSize=1)
public class Livro implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqLivro")
	@Column(nullable = false)
	private int isbn;
	
	@Column(nullable = false)
	private String titulo;
	
	private float preco;
	
	@Temporal(TemporalType.DATE)
	private Calendar dt_lancamento;
	
	@Lob
	private byte[] capa;
	
	@ManyToMany
	@JoinTable(name="Autor_Livro", joinColumns = {@JoinColumn(name="id")},
	inverseJoinColumns={@JoinColumn(name="isbn")})
	private List<Autor> autores;

	@ManyToOne
	@JoinColumn(name="id")
	private Editora editora_id; 
	
	public Livro() {
		super();
	}
	public Livro(int isbn, String titulo, float preco, Calendar dt_lancamento, byte[] capa) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.dt_lancamento = dt_lancamento;
		this.capa = capa;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Calendar getDt_lancamento() {
		return dt_lancamento;
	}
	public void setDt_lancamento(Calendar dt_lancamento) {
		this.dt_lancamento = dt_lancamento;
	}
	public byte[] getCapa() {
		return capa;
	}
	public void setCapa(byte[] capa) {
		this.capa = capa;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	public Editora getEditora() {
		return editora_id;
	}
	public void setEditora(Editora editora_id) {
		this.editora_id = editora_id;
	}
	
}

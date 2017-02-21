package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro implements Serializable{
	
	@Id
	@Column(nullable = false)
	private int isbn;
	
	@Column(nullable = false)
	private String titulo;
	
	private float preco;
	
	@Temporal(TemporalType.DATE)
	private Calendar dt_lancamento;
	
	@Lob
	private byte[] capa;

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
	
	
}

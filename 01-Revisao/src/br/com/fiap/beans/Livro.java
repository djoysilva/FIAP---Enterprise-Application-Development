package br.com.fiap.beans;

import java.util.Calendar;

public class Livro extends Produto{
	private String autor;
	private String editora;
	private Calendar data;
	public Livro() {
		super();
	}
	
	public Livro(String autor, String editora, Calendar data) {
		super();
		this.autor = autor;
		this.editora = editora;
		this.data = data;
	}
	
	
	public Livro(int codigo, String titulo, double preco, String autor,
			String editora, Calendar data) {
		super(codigo, titulo, preco);
		this.autor = autor;
		this.editora = editora;
		this.data = data;
	}

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	
}

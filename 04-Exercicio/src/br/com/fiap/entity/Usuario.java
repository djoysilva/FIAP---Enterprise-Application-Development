package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sqUsuario", sequenceName="SEQ_TB_USUARIO", allocationSize = 1)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqUsuario")
	@Column(nullable = false)
	private int  id;
	
	@Column(nullable = false)
	private String nome_usuario;
	
	@Column(nullable = false)
	private String nome;
	
	private String sobrenome;
	
	@Column(nullable = false)
	private String cpf;

	public Usuario() {
		super();
	}

	public Usuario(int id, String nome_usuario, String nome, String sobrenome, String cpf) {
		super();
		this.id = id;
		this.nome_usuario = nome_usuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}

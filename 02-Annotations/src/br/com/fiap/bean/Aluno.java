package br.com.fiap.bean;

import br.com.fiap.annotation.Tabela;

public class Aluno {
	@Tabela(nome = "TB_NOME")
	private String nome;
}

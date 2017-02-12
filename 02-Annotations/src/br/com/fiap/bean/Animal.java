package br.com.fiap.bean;

import br.com.fiap.annotation.Coluna;

public class Animal {
	
	@Coluna(nome="NM_ANIMAL")
	private String nome;
	
	@Coluna(nome="DS_ESPECIE")
	private String especie;
	
	private double preco;
	
	public void andar(){
		System.out.println("Andando...");
		
	}
}

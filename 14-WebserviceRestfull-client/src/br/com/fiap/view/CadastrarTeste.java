package br.com.fiap.view;

import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class CadastrarTeste {
	public static void main(String[] args){
		ProdutoRepository rep = new ProdutoRepository();
		try{
			ProdutoTO produto = new ProdutoTO(0, "Arduino", 100, 1000);
			rep.cadastrar(produto);
			System.out.println("Produto cadastrado!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

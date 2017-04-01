package br.com.fiap.view;

import br.com.fiap.repository.ProdutoRepository;

public class DeletarTeste {
	public static void main(String[] args){
		ProdutoRepository rep = new ProdutoRepository();
		try{
			rep.remover(1);
			System.out.println("Deletado!");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}


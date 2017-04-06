package br.com.fiap.view;

import java.util.List;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.AtletaTO;

public class BuscarTeste {
	public static void main(String[] args){
		AtletaRepository rep = new AtletaRepository();
		
		try{
			System.out.println("Listagem");
			List<AtletaTO> atletas = rep.listar();
			
			for (AtletaTO atleta : atletas) {
				System.out.println(atleta.getNome() + " " + atleta.getCodigo());
			}
			
			System.out.println("Busca por codigo");
			AtletaTO atleta = rep.buscar(4);
			System.out.println("Nome antigo: " + atleta.getNome());
			
			atleta.setNome("Joyce");
			
			rep.atualizar(atleta);
			
			System.out.println("Nome novo: " + atleta.getNome());
			
			rep.remover(9);
					
		}catch(WebServiceException e){
			e.printStackTrace();
		}
	}
}

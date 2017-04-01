package br.com.fiap.view;

import java.util.List;

import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.AtletaTO;

public class ListarTeste {
	public static void main(String[] args){
		AtletaRepository rep = new AtletaRepository();
		try{
			List<AtletaTO> lista = rep.listar();
			for (AtletaTO atletaTO : lista) {
				System.out.println(atletaTO.getCodigo());
				System.out.println(atletaTO.getModalidade());
				System.out.println(atletaTO.getNome());
				System.out.println(atletaTO.getRanking());
			}
		}catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

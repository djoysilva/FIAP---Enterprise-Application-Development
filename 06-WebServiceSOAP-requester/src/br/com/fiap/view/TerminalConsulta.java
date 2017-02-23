package br.com.fiap.view;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularMedia;
import br.com.fiap.bo.DisciplinaBOStub.CalcularMediaResponse;

public class TerminalConsulta {
	public static void main(String[] args){
		try{
			//chamar o webservice
			DisciplinaBOStub bo = new DisciplinaBOStub();
			
			//Valores para o webService
			CalcularMedia valores = new CalcularMedia();
			valores.setAm(10);
			valores.setNac(10);
			valores.setPs(5);
			
			//Chama o webservice
			CalcularMediaResponse response = bo.calcularMedia(valores);
			
			//Recupera o retorno do web service
			double media = response.get_return();
			
			System.out.println("Mádia: " + media);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

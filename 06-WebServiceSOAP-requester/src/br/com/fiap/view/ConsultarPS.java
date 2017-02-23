package br.com.fiap.view;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularPs;
import br.com.fiap.bo.DisciplinaBOStub.CalcularPsResponse;

public class ConsultarPS {
	public static void main(String[] args){
		try{
			//Chamar o servi�o de calcular nota da ps necess�ria
			DisciplinaBOStub bo = new DisciplinaBOStub();
			CalcularPs valores = new CalcularPs();
			valores.setNac(5);
			valores.setAm(6);
			
			CalcularPsResponse response = bo.calcularPs(valores);
			
			double ps = response.get_return();
			System.out.println("Voc� precisa de: " + ps);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}

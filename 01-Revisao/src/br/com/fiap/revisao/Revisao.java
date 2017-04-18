package br.com.fiap.revisao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.beans.Sexo;

public class Revisao {

	public static void main(String[] args) {
		//Declarar uma variavel para armazenar data
		Calendar inicioAula;
		//Armazenar na variavel a data de hoje
		inicioAula = Calendar.getInstance();
		
		//Declarar uma variavel para data
		Calendar terminoAula =   //Ano, mes (comeca no 0) e dia 
				new GregorianCalendar(2017,Calendar.JUNE,28);
		
		//exibir as datas
		//Formatador de data
		SimpleDateFormat formatador = 
				new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Come�o: " + 
				formatador.format(inicioAula.getTime()));
		System.out.println("T�rmino: " + 
				formatador.format(terminoAula.getTime()));
		
		//Instanciar uma pessoa
		Pessoa pessoa = new Pessoa("Jonas",
			new GregorianCalendar(1994, Calendar.AUGUST, 7),
			Sexo.MASCULINO);
		
		//Comparar um enum
		if (pessoa.getSexo() == Sexo.MASCULINO){
			System.out.println("Homem");
		}else{
			System.out.println("Mulher");
		}
		
	}
	
}

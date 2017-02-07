package br.com.fiap.revisao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.beans.Sexo;

public class Revisao {
	public static void main(String args[]){
		Calendar inicioAula;
		inicioAula = Calendar.getInstance();
		
		Calendar terminoAula = new GregorianCalendar(2017, Calendar.JUNE,28);
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		
		JOptionPane.showMessageDialog(null, "Inicio aula:" + formatador.format(inicioAula.getTime()));
		JOptionPane.showMessageDialog(null, "Término aula:" + formatador.format(terminoAula.getTime()));
		
		
		//instanciar uma pessoa
		Pessoa pessoa = new Pessoa("Joyce", new GregorianCalendar(1988, Calendar.JUNE, 22), Sexo.FEMININO);
		
		//Comparar um enum
		if(pessoa.getSexo() == Sexo.FEMININO){
			System.out.println("Feminino");
		}else{
			System.out.println("Homem");
		}
	}
}

package com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TerminalConsulta {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		System.out.println("FIAP            " +
					sdf.format(Calendar.getInstance().getTime()));
		System.out.println("********************************");
		
		System.out.print("Digite o código: ");
		int codigo = scanner.nextInt();
		
		switch (codigo) {
		case 401:
			System.out.println("Camiseta Masculina Manga Curta Branca");
			break;
		case 402:
			System.out.println("Camiseta Feminina Manga Longa Rosa");
			break;
		default:
			System.out.println("Produto não cadastrado!");
			break;
		}
		
		scanner.close();
		
	}
	
}

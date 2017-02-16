package com.fiap.loja;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fiap.loja.bo.EstoqueBO;
import com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {
	private static Logger log = LoggerFactory.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) {
	
		try{
			Scanner scanner = new Scanner(System.in);
			
			log.warn("Inicio da aplica��o");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			System.out.println("FIAP            " +
						sdf.format(Calendar.getInstance().getTime()));
			System.out.println("********************************");
			
			System.out.print("Digite o codigo: ");
			int codigo = scanner.nextInt();
			
			EstoqueBO bo = new EstoqueBO();
			ProdutoTO produto = bo.consultarProduto(codigo);
			
			log.debug("Produto pesquisado - codigo:" + codigo);
			
			if(produto != null){
				System.out.println(produto.getDescricao());
				System.out.println(produto.getQuantidade());
				//formatar o valor monet�rio
				DecimalFormat format = new DecimalFormat("R$ #,###.00");
				System.out.println(format.format(produto.getPreco()));
			}else{
				log.error("C�digo de produto inexistente");
				System.out.println("Produto n�o cadastrado!");
			}
			
			switch (codigo) {
			case 401:
				System.out.println("Camiseta Masculina Manga Curta Branca");
				break;
			case 402:
				System.out.println("Camiseta Feminina Manga Longa Rosa");
				break;
			default:
				System.out.println("Produto n�o cadastrado!");
				break;
			}
			
			scanner.close();
			log.warn("Fim da aplica��o");
		}catch(InputMismatchException e){
				System.out.println("C�digo inv�lido");
				log.error("C�digo inv�lido");
		}	
	}
	
}

package br.com.fiap.testes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Tablet;

public class teste3 {
	public static void main(String args[]){
		int opcao = 0;
		ArrayList<Tablet> listaTablet = new ArrayList<Tablet>();
		
		while(opcao != 3){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: " + 
																  "\n1 - Cadastrar tablet " +
																  "\n2 - Exibir tablets cadastrador " +
																  "\n3 - Sair"));
			switch(opcao){
				case 1: Tablet tablet = new Tablet(
						Integer.parseInt(JOptionPane.showInputDialog("Código?")),
						JOptionPane.showInputDialog("Título?"),
						Double.parseDouble(JOptionPane.showInputDialog("Preço?")),
						JOptionPane.showInputDialog("Marca?"),
						JOptionPane.showInputDialog("Modelo?"),
						JOptionPane.showInputDialog("Sistema Operacional?"),
						Boolean.parseBoolean(JOptionPane.showInputDialog("Possui 3G?")));
						
						listaTablet.add(tablet);
						break;
				
				case 2:	if(listaTablet.isEmpty()){
							JOptionPane.showMessageDialog(null, "Lista vazia");
						}else{
							for(Tablet novoTablet : listaTablet){
								JOptionPane.showMessageDialog(null, "O valor do produto: " + novoTablet.getModelo() + 
																	" é: " + novoTablet.getPreco());
							}
						}
						break;
						
				case 3:	break;
						
				default: break;
			}
					
					
					
		}
	}
}

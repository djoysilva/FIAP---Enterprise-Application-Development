package br.com.fiap.testes;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Livro;

public class teste2 {
	public static void main(String args[]){
		List<Livro> listaLivros = new ArrayList<Livro>();
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dataNova = new SimpleDateFormat();

		for(int i = 0; i<3; i++){
			Livro livro = new Livro();

			
			livro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código?")));
			livro.setTitulo(JOptionPane.showInputDialog("Título?"));
			livro.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Preço?")));
			livro.setAutor(JOptionPane.showInputDialog("Autor?"));
			livro.setEditora(JOptionPane.showInputDialog("Editora?"));
			livro.setData(Calendar.getInstance());

			listaLivros.add(livro);
		}
		
		for(Livro novoLivro : listaLivros){
			String livroDataFormatada = new String(formatarData.format(novoLivro.getData().getTime()));
			
			JOptionPane.showMessageDialog(null, 
										"\nCódigo: " + novoLivro.getCodigo() +
										"\nTítulo: " + novoLivro.getTitulo() +
										"\nPreço: " + novoLivro.getPreco() +
										"\nAutor: " + novoLivro.getAutor() +
										"\nEditora: " + novoLivro.getEditora() +
										"\nData: " + livroDataFormatada);
		}
	}
}

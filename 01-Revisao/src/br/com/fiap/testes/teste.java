package br.com.fiap.testes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import br.com.fiap.beans.Livro;
import br.com.fiap.beans.Tablet;

public class teste {
	public static void main(String args[]){
		Tablet tablet = new Tablet(1, "TI", 10.00, "Ipad", "Apple", "IoS", true);
		Livro livro = new Livro(2, "Terror", 40.00, "Joyce", "Poe", Calendar.getInstance());
		
		SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
		
		String dataFormatadaLivro = new String(formatadorData.format(livro.getData().getTime()));
	
		JOptionPane.showMessageDialog(null, "Produto 1" +
										"\nCódigo: " + tablet.getCodigo() +
										"\nTítulo: " + tablet.getTitulo() +
										"\nPreço: " + tablet.getPreco() +
										"\nModelo: " + tablet.getModelo() +
										"\nMarca: " + tablet.getMarca() +
										"\nSistema Operacional: " + tablet.getsO() +
										"\n3g: " + tablet.isTresG() + 
										"\n\nProduto 2 " +
										"\nCódigo: " + livro.getCodigo() +
										"\nTítulo: " + livro.getTitulo() +
										"\nPreço: " + livro.getPreco() +
										"\nAutor: " + livro.getAutor() +
										"\nEditora: " + livro.getEditora() +
										"\nData: " + dataFormatadaLivro);
		
		tablet.setPreco(tablet.calcularGarantia());
		JOptionPane.showMessageDialog(null, tablet.getPreco());
	}
}

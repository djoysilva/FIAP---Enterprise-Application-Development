package br.com.fiap.revisao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Livro;
import br.com.fiap.beans.Tablet;
import br.com.fiap.dao.TabletDAO;

public class Testes {

	public static void main(String[] args) {
		Tablet tablet = new Tablet(1, "", 555, "", "", "", true);
		Tablet tablet2 = new Tablet(2, "", 555, "", "", "", true);
		Tablet tablet3= new Tablet(3, "", 555, "", "", "", true);

		Calendar dataLancamento = new GregorianCalendar();
		dataLancamento.set(2009, 02, 03);
		Livro livro = new Livro(1, "", 333, "", "", dataLancamento);
		System.out.println(livro.getDataLancamento().getTime().toString());
		System.out.println(tablet.calcularGarantiaEstendida());
		
		int menu = Integer.parseInt(JOptionPane.showInputDialog("1- Cadastrar\n2-Exibir\n0- Sair"));
		TabletDAO dao = new TabletDAO();
		while(menu != 0) {
			if(menu == 1) {
				Tablet newTablet = new Tablet(Integer.parseInt(JOptionPane.showInputDialog("Codigo:")), JOptionPane.showInputDialog("Titulo: "), Double.parseDouble(JOptionPane.showInputDialog("Preco: ")));
				dao.cadastrarTablet(newTablet);
				menu = Integer.parseInt(JOptionPane.showInputDialog("1- Cadastrar\n2-Exibir\n0- Sair"));
			}
			else if(menu == 2) {
				List<Tablet> lista = dao.exibirTablets();
				for(Tablet tab: lista) {
					JOptionPane.showMessageDialog(null, tab.getCodigo());
				}
				menu = Integer.parseInt(JOptionPane.showInputDialog("1- Cadastrar\n2-Exibir\n0- Sair"));
			}	
		}
	}
}

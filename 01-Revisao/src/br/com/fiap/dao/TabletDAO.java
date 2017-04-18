package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Tablet;

public class TabletDAO {
	private List<Tablet> lista = new ArrayList();
	
	public void cadastrarTablet(Tablet tablet) {
		if (tablet != null) {
			lista.add(tablet);
		}
	}
	public List<Tablet> exibirTablets() {
		return lista;
	}
}

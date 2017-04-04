package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{
	
	List<Pacote> listar();
	
	List<Pacote> buscarPorPreco(float maximo);
	
	List<Pacote> buscarIsTransporte(Transporte transporte);
		
}

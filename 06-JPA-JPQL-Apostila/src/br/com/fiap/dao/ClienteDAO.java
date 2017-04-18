package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	List<Cliente> listar();
	List<Cliente> listarPorEstado(String estado);
	List<Cliente> buscarPorDiaReserva(int quantidade);
	List<Cliente> buscar(String nome, String cidade);
	List<Cliente> buscarPorEstado(List<String> estados);
	
	long quantidadeDeClientes();
	
	Cliente buscarPorCpf(String cpf);
	List<Cliente> buscarPorMesAniversario(int mes);
}

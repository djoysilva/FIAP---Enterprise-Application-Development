package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Funcionario;

public class TesteRefresh {

	public static void main(String[] args) {
		//EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar um funcionario
		Funcionario funcionario = em.find(Funcionario.class, 1);
		System.out.println("Apos o find: " + funcionario.getNome());
		
		//Alteracao
		funcionario.setNome("Kelly");
		System.out.println("Alterou o nome para " + funcionario.getNome());
		
		//Refresh: as informa�oes que estavam no banco sao preenchidas
		em.refresh(funcionario);
		System.out.println("Apos o refresh: " + funcionario.getNome());
		
	}

}

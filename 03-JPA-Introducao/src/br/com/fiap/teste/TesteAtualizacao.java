package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Funcionario;

public class TesteAtualizacao {

	public static void main(String[] args) {
		//EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar o funcionario
		Funcionario funcionario = em.find(Funcionario.class, 1);
		
		//Alterar os valores do funcionario
		funcionario.setNome("Armagedon");
		
		//Atualizar um funcionario
		em.merge(funcionario);
		
		//Transacao
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Funcionario atualizado");
		System.exit(0);
		
	}

}

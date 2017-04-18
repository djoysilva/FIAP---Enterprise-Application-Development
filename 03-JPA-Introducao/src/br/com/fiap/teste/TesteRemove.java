package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Funcionario;

public class TesteRemove {

	public static void main(String[] args) {
		//Entitymanager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar o funcionario
		Funcionario funcionario = em.find(Funcionario.class, 1);
		
		//Remove o funcionario do banco de dados
		em.remove(funcionario);
		
		//Transacao
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Funcionario removido!");
		System.exit(0);
	
	}

}

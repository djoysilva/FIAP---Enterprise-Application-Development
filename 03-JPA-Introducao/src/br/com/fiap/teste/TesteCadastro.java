package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Sexo;

public class TesteCadastro {

	public static void main(String[] args) {
		//Cadastrar um funcionario
		
		//Instanciar a classe funcionario
		Funcionario funcionario = new Funcionario(0, "Gondo", new GregorianCalendar(2000, Calendar.JANUARY, 11), Calendar.getInstance(), 0, null, Sexo.MASCULINO);
		
		//Obter uma instancia de entityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
				
		//Chamar o m�todo do entityManager para persistir o funcionario
		em.persist(funcionario);
		
		//Iniciar e finalizar uma transacao
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		
		//Sucesso!
		System.out.println("Funcionario cadastrado");
		System.exit(0);
	}

}

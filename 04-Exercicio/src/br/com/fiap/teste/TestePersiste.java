package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Livro;
import br.com.fiap.entity.Sexo;


public class TestePersiste {
	public static void main(String[] args) throws Exception{
		try{
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
			EntityManager em = fabrica.createEntityManager();
			
			Editora editora = new Editora(0, "1234", "Abril", "Rua Tabajaras");
			em.persist(editora);
			Autor autor = new Autor(0, "Autor", "FIAP", Sexo.FEMININO, new GregorianCalendar(1988, Calendar.JUNE, 22));
			em.persist(autor);
			Livro livro = new Livro(0, "Ola", 10, new GregorianCalendar(1988, Calendar.JUNE, 22), null);
			em.persist(livro);
			
			em.getTransaction().begin();
			em.getTransaction().commit();
			em.close();
			
			System.out.println("Funcionário cadastrado!");
		}catch(Exception e){
			throw new Exception("Não cadastrou");
		}
		
	}
}

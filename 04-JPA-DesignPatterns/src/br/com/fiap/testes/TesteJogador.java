package br.com.fiap.testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.JogadorDAO;
import br.com.fiap.dao.impl.JogadorDAOImpl;
import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Sexo;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteJogador {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Cadastrar um jogador
		Jogador jogador = new Jogador(0, "Pele", 7, 2, Sexo.MASCULINO, new GregorianCalendar(2000, 12, 11));
		JogadorDAO dao = new JogadorDAOImpl(em);
		
		try {
			dao.insert(jogador);
			dao.save();
		}
		catch(CommitException e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}

}

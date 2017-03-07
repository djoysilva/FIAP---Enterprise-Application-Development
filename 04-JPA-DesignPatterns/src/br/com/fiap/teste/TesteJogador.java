package br.com.fiap.teste;

import java.util.Calendar;
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
		// Cadastrar um jogador
		Jogador jogador = new Jogador(0,"Zidane", 10, 1.8, Sexo.MASCULINO, new GregorianCalendar(1975, Calendar.OCTOBER, 10));
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		JogadorDAO dao = new JogadorDAOImpl(em);
		
		try{
			dao.insert(jogador);
			dao.save();
		}catch(CommitException e){
			e.printStackTrace();
		}
		
		System.exit(0);
	}

}

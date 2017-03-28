package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Campeonato;
import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Tecnico;
import br.com.fiap.entity.Time;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class testeRelacionamentos{
	public static void main(String[] args){
		Time time = new Time(0, "Nome", new GregorianCalendar(2017, Calendar.APRIL, 21), 10);
		Campeonato campeonato = new Campeonato(0, "Campeonato");
		Jogador jogador = new Jogador(0, "jogador");
		Tecnico tecnico = new Tecnico(0,"tecnico");
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		TimeDAO timedao = new TimeDAOImpl(em);
		
		time.setTecnico(tecnico);
		jogador.setTime(time);
		time.addJogador(jogador);
		
		List<Time> times = new ArrayList<>();
		campeonato.setTime(times);
		
		
		try{
			timedao.insert(time);
			System.out.println("Time: " + time.getNome() + "\nTecnico: " + time.getTecnico());
			
			System.exit(0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

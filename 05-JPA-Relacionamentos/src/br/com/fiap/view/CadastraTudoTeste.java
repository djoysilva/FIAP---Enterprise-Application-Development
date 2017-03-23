package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastraTudoTeste {
	public static void main(String[] args){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		GrupoAm grupo = new GrupoAm(0, "grupo");
		GrupoAmDAO grupoDao = new GrupoAmDAOImpl(em);
		ProjetoAm projeto = new ProjetoAm(0, "Natureba", new GregorianCalendar(2017, Calendar.OCTOBER, 20), 10, "Projeto");
		List<Professor> professores = new ArrayList<>();
		
		grupo.setProjeto(projeto);
		projeto.setGrupo(grupo);
		
		grupo.addAluno(new Aluno(0, "Joyce"));
		grupo.addAluno(new Aluno(0, "Chris"));
		grupo.addAluno(new Aluno(0, "Juju"));
		
		professores.add(new Professor(0, "Humberto", new GregorianCalendar(2012, Calendar.OCTOBER, 20)));
		professores.add(new Professor(0, "Rita", new GregorianCalendar(2012, Calendar.OCTOBER, 20)));
		professores.add(new Professor(0, "Thiago", new GregorianCalendar(2012, Calendar.OCTOBER, 20)));

		for(Aluno aluno : grupo.getAlunos()){
			aluno.setProfessor(professores);;
		}
			
		try{
			grupoDao.insert(grupo);
			grupoDao.save();
			System.out.println("Sucesso em add");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		
	}
}

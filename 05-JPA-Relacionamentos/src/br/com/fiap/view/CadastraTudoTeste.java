package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.entity.Professor;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastraTudoTeste {
	public static void main(String[] args){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		Aluno aluno = new Aluno(0, "alun");
		GrupoAm grupo = new GrupoAm(0, "grupo");
		Professor professor = new Professor();
		
		GrupoAmDAO grupoDao = new GrupoAmDAOImpl(em);
		
		professor.getAlunos().add(aluno);
		grupo.addAluno(aluno);
		
		try{
			grupoDao.insert(grupo);
			grupoDao.save();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		
	}
}

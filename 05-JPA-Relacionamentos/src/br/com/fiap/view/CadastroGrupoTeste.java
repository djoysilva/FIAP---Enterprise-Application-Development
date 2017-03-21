package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroGrupoTeste {
	public static void main(String[] args){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		GrupoAmDAO grupoDao = new GrupoAmDAOImpl(em);
		
		Aluno aluno = new Aluno(0, "aluno");
		GrupoAm grupo = new GrupoAm(0, "grupo");
		
		grupo.addAluno(aluno);
		
		try{
			grupoDao.insert(grupo);
			grupoDao.save();
			
			System.out.println(aluno.getGrupo().getNome());
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			em.close();
			System.exit(0);
		}
	}
}

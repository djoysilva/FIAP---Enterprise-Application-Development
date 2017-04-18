package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroGrupoAlunoTeste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Aluno aluno = new Aluno();
		aluno.setNome("Aae");
		GrupoAm grupo = new GrupoAm(0, "aaAaA");
		GrupoAmDAO dao = new GrupoAmDAOImpl(em);
		
		grupo.addAluno(aluno);

		try {
			dao.insert(grupo);
			dao.save();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			System.exit(0);
		}
		
		em.close();		
	}
}

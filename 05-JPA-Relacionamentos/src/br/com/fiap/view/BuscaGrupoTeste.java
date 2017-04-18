package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class BuscaGrupoTeste {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		GrupoAmDAO grupoDAO = new GrupoAmDAOImpl(em);
		
		GrupoAm grupo = grupoDAO.findById(1);
		
		System.out.println(grupo.getNome() + "\n" + grupo.getProjeto().getNome());
		
		em.close();
		System.exit(0);
	}

}

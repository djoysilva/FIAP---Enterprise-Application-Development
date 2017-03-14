package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class BuscaGrupoTeste {
	public static void main(String[] args){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		GrupoAmDAO dao = new GrupoAmDAOImpl(em);
		
		GrupoAm grupo = dao.findById(1);
		
		System.out.println(grupo.getNome());
		System.out.println(grupo.getProjeto().getNome());
		
		em.close();
				
	}
}

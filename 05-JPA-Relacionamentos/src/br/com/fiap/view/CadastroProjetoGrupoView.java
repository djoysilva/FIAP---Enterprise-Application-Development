package br.com.fiap.view;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroProjetoGrupoView {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		GrupoAm grupo = new GrupoAm(0, "Cherona");
		ProjetoAm projeto = new ProjetoAm(0, "Hyukka", new GregorianCalendar(2000, 12, 11), 6, null, grupo);
		
		ProjetoAmDAO dao = new ProjetoAmDAOImpl(em);
		GrupoAmDAO gdao = new GrupoAmDAOImpl(em);
		
		projeto.setGrupo(grupo);
		
		gdao.insert(grupo);
		dao.insert(projeto);
		
		try {
			dao.save();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	
	}

}

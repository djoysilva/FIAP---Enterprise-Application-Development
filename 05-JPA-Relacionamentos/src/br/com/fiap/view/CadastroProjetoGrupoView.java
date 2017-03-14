package br.com.fiap.view;

import java.util.Calendar;
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
		//Cadastrar um projeto e um grupo:
		GrupoAm grupo = new GrupoAm(0, "Moriarty");
		ProjetoAm projeto = new ProjetoAm(0, "AAA", new GregorianCalendar(1988, Calendar.APRIL, 22), 10, "oi");
		
		//Obter uma instacia do EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		//Instanciar os DAOs
		ProjetoAmDAO dao = new ProjetoAmDAOImpl(em);
		GrupoAmDAO gdao = new GrupoAmDAOImpl(em);
		
		//Instanciar um grupo e um projeto
		
		//Cadastrar utilizando o DAO
		projeto.setGrupo(grupo);
		gdao.insert(grupo);
		dao.insert(projeto);
		
		//Commit
		try{
			dao.save();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			em.close();
		}
		//Sucesso!
	}
	
}

package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.dao.impl.ProjetoAmDAOimpl;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroProjetoGrupoView {
	public static void main(String[] args) throws Exception{
		ProjetoAm projeto = new ProjetoAm(0,"nome", new GregorianCalendar(1988, Calendar.MARCH, 22), 22,"oi");
		GrupoAm grupo = new GrupoAm();
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ProjetoAmDAO projDao = new ProjetoAmDAOimpl(em);
		
		try{
			projDao.insert(projeto);
			projDao.save();
			System.out.println("Adicionado com sucesso!");
		}catch(Exception e){
			throw new Exception("Erro no cadastro");
		}
	}
}

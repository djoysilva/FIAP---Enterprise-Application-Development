package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DependenteDAO;
import br.com.fiap.dao.impl.DependenteDAOImpl;
import br.com.fiap.entity.Dependente;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class View {
	public static void main(String[] args){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		DependenteDAO dao = new DependenteDAOImpl(em);
		
		Funcionario func = new Funcionario();
		func.setNome("Joyce");
		func.setDataAdmissao(new GregorianCalendar(2013, Calendar.APRIL, 23));
		
		func.setSalario(2.500);
		func.setNumeroConta(1231);
		
		Dependente dep = new Dependente();
		dep.setNome("Ju");
		dep.setFuncionario(func);
		
		try{
			dao.insert(dep);
			dao.save();
		}catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		System.exit(0);
	}
}

package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.dao.impl.ContaDAOImpl;
import br.com.fiap.entity.Agencia;
import br.com.fiap.entity.Conta;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {
	public static void main(String[] args){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ContaDAO dao = new ContaDAOImpl(em);
		Agencia agencia = new Agencia(0, "endereço");
		Conta conta = new Conta(0, agencia, 10.1);
		
		try{
			dao.insert(conta);
			dao.save();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			System.exit(0);
		}
		
	}
}

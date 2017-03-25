package br.com.fiap.bo;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AtletaDAO;
import br.com.fiap.dao.impl.AtletaDAOImpl;
import br.com.fiap.entity.Atleta;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class AtletaBO {
	private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private AtletaDAO dao = new AtletaDAOImpl(em);
	
	public Atleta buscar(int codigo){
		return dao.pesquisar(codigo);
	}
	
	public void cadastrar(Atleta atleta){
		try{
			dao.cadastrar(atleta);
			dao.salvar();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public void atualizar(Atleta atleta){
		try{
			dao.alterar(atleta);
			dao.salvar();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public void remover(int codigo){
		try{
			dao.remover(codigo);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
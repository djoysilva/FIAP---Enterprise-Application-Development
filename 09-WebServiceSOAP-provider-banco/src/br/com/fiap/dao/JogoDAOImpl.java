package br.com.fiap.dao;

import javax.persistence.EntityManager;
import br.com.fiap.dao.impl.GenericDAOImpl;
import br.com.fiap.entity.Jogo;

public class JogoDAOImpl extends GenericDAOImpl<Jogo, Integer> implements JogoDAO {
	public JogoDAOImpl(EntityManager em){
		super(em);
	}
}

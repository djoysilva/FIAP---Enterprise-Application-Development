package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> listar() {
		TypedQuery<Pacote> query = em.createQuery("from Pacote", Pacote.class);
		return 	query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorPreco(float maximo) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.preco < :pre", Pacote.class);
		query.setParameter("pre", maximo);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarIsTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.transporte =:transp", Pacote.class);
		query.setParameter("transp", transporte);
		return query.getResultList();
	}

}

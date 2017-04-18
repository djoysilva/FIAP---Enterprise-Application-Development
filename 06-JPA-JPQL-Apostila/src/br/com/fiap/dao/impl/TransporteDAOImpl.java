package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.entity.Transporte;

public class TransporteDAOImpl extends GenericDAOImpl<Transporte,Integer> implements TransporteDAO{

	public TransporteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Transporte buscar(int id) {
		TypedQuery<Transporte> query = em.createQuery("from Transporte t where t.id =:i", Transporte.class);
		query.setParameter("i", id);

		return query.getSingleResult();
	}

}

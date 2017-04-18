package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorPreco(float maximo) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.preco < :pre", Pacote.class);
		query.setParameter("pre", maximo);
		
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.transporte = :trans", Pacote.class);
		query.setParameter("trans", transporte);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.dataSaida between :ini and :fi", Pacote.class);
		query.setParameter("ini", inicio);
		query.setParameter("fi", fim);
		return query.getResultList();
	}

	@Override
	public double precoMedio() {
		TypedQuery<Double> query = em.createQuery("select avg(p.preco) from Pacote p", Double.class);
		
		return query.getSingleResult();
	}

	@Override
	public long pacotesCadastradosEntreDatas(Calendar inicio, Calendar fim) {
		TypedQuery<Long> query = em.createQuery("select count(p) from Pacote p where p.dataSaida between :ini and :fi", Long.class);
		query.setParameter("ini", inicio);
		query.setParameter("fi", fim);
		return query.getSingleResult();
	}

	@Override
	public List<Pacote> pacoteMaiorPreco() {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p2 where p2.preco = (select max(p.preco) from Pacote p)", Pacote.class);
		return query.getResultList();
	}

}

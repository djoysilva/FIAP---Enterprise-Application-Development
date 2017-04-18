package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		
		return query.getResultList();
	}

	@Override
	public List<Cliente> listarPorEstado(String estado) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.endereco.cidade.uf = :est", Cliente.class);
		query.setParameter("est", estado);

		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiaReserva(int quantidade) {
		TypedQuery<Cliente> query = em.createQuery("select r.cliente from Reserva r where r.numeroDias = :num", Cliente.class);
		query.setParameter("num", quantidade);
		query.setMaxResults(50);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nome like :nom and c.endereco.cidade.nome like :cid", Cliente.class);
		query.setParameter("nom", "%"+nome+"%");
		query.setParameter("cid", "%"+cidade+"%");
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(List<String> estados) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.endereco.cidade.uf in :est", Cliente.class);
		query.setParameter("est", estados);
		return query.getResultList();
	}

	@Override
	public long quantidadeDeClientes() {
		TypedQuery<Long> query = em.createQuery("select count(c) from Cliente c", Long.class);
		return query.getSingleResult();
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		return em.createNamedQuery("Cliente.porCpf", Cliente.class).setParameter("cpf", cpf).getSingleResult();
	}

	@Override
	public List<Cliente> buscarPorMesAniversario(int mes) {
		return em.createNamedQuery("Cliente.porMesAniversario", Cliente.class).setParameter("mes", mes).getResultList();
	}

}

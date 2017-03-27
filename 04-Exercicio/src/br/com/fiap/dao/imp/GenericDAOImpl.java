package br.com.fiap.dao.imp;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K> {
	
	private EntityManager em;
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void insert(T entidade) {
		em.persist(entidade);		
	}

	@Override
	public void update(T entidade){
		em.merge(entidade);
	}

	@Override
	public void delete(K id) {
		T entidade = findByid(id);
		if(entidade == null){
			System.out.println("Entidade não existe");
		}
		em.remove(findByid(id));
	}

	@Override
	public T findByid(K id) {
		return em.find(clazz, id);
	}
	
	
}

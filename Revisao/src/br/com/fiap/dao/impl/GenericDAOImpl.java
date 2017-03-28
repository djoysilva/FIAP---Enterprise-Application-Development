package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import br.com.fiap.dao.GenericDAO;


public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {		
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
							.getActualTypeArguments()[0];
	}
	
	@Override
	public void insert(T entidade){
		em.persist(entidade);
	}

	public void save() {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive()){//valida se existe uma transação ativa
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			
		}
	}

	@Override
	public void update(T entidade) {
		em.merge(entidade);
	}

	@Override
	public void delete(K id) throws EntityNotFoundException {
		T entidade = findByid(id);
		if(entidade == null){
			throw new EntityNotFoundException("Entidade não existe");
		}		
		em.remove(findByid(id));
	}

	@Override
	public T findByid(K id) {
		return em.find(clazz, id);
	}

	
}

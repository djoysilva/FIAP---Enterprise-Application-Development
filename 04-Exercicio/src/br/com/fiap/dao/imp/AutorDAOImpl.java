package br.com.fiap.dao.imp;

import br.com.fiap.entity.Autor;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AutorDAO;

public class AutorDAOImpl extends GenericDAOImpl<Autor, Integer> implements AutorDAO{

	public AutorDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}

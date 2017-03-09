package br.com.fiap.dao.impl;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.entity.GrupoAm;

public class GrupoAmDAOimpl extends GenericDAOImpl<GrupoAm, Integer> implements GrupoAmDAO{

	public GrupoAmDAOimpl(EntityManager em) {
		super(em);
		
	}

}

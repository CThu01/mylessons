package com.jdc.mkt.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jdc.mkt.entity.Category;

@Repository
public class CategoryRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Category create(Category category) {
		em.persist(category);
		return category;
	}
}

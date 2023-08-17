package com.jdc.mkt.repo;

import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CourseRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Course create(Course c) {
		em.persist(c);
		return c;
	}
}

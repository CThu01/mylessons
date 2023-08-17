package com.jdc.mkt;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.entity.Person;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


@SpringJUnitConfig(locations = "/application.xml")
public class PersonTest {

//	private EntityManagerFactory emf;
//
//	@Test
//	
//	void test1() {
//		emf = Persistence.createEntityManagerFactory("spring-orm");
//		var em = emf.createEntityManager();
//
//		var p = new Person();
//		p.setName("William");
//		p.setAge(30);
//
//		em.getTransaction().begin();
//		em.persist(p);
//		em.getTransaction().commit();
//	}
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	void test1() {
		var p = new Person();
		p.setName("John");
		p.setAge(20);
		em.persist(p);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
package com.jdc.mkt.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdc.mkt.entity.Customer;

//@Repository
//public class CustomerRepo {
//
//	@PersistenceContext
//	private EntityManager em;
//	
//	@Transactional
//	public void create(Customer cu) {
//		em.persist(cu.getAddress());
//		em.persist(cu);
//	}
//}

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
}

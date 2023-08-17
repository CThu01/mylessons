package com.jdc.mkt.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.ProductPk;

public class ProductTest {

	private static EntityManagerFactory emf;
	private  EntityManager em;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("SPRING-DATA");
	}
	
	@ParameterizedTest
	@CsvSource(value="Orange:300:001:M",delimiter = ':')
	void test1(String name,int price,String code,String size) {
		
		em.getTransaction().begin();
		var category = new Category("Food");
		em.persist(category);
		System.out.println("Category >>>>>> %d".formatted(category.getId()));
		
//		var productPk = new ProductPk(code,size);
		var product = new Product(name, price, category);
//		product.setCode(code);
//		product.setSize(size);
		em.persist(product);
//		System.out.println("Product >>>>>>> %s".formatted(product.getSize()));
		
		em.getTransaction().commit();
	}
	
	
	@BeforeEach
	void createEntityManager() {
		em = emf.createEntityManager();
	}
	@AfterEach
	void closeEntiryManger() {
		if(null != em || em.isOpen()) {
			em.close();
		}
	}
		
	
	@AfterAll
	static void close() {
		if(null != emf || emf.isOpen()) {
			emf.close();
		}
	}
}

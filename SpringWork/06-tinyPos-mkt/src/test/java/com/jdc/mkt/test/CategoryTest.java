package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.dao.CategoryDao;
import com.jdc.mkt.dto.Category;


@TestMethodOrder(OrderAnnotation.class)
public class CategoryTest {

	private static CategoryDao dao;
	
	@BeforeAll
	static void init() {
		dao = new CategoryDao();
		
	}
	
	
	
//	@ParameterizedTest
//	@DisplayName("1. insert Query")
//	@ValueSource(strings = "accessorces")
//	@Order(1)
//	void test1(String name) {
//		
//		var cat = new Category();
//		cat.setName(name);
//		int res = dao.insert(cat);
//		assertEquals(11, res);
//		
//	}
//	
	
//	
//	@ParameterizedTest
//	@DisplayName("1. insert Query")
//	@CsvSource("8,access")
//	@Order(2)
//	void test2(int id,String name) {
//		
//		var cat = new Category();
//		cat.setId(id);
//		cat.setName(name);
//		int res = dao.update(cat);
//		assertEquals(1, res);
//		
//	}
//	
//	
//	@ParameterizedTest
//	@DisplayName("1. delete query")
//	@ValueSource(ints = 8)
//	@Order(3)
//	void test3(int id) {
//		
//		var cat = new Category();
//		cat.setId(id);
//
//		int res = dao.delete(id);
//		assertEquals(1, res);
//		
//	}
	
	
	
	@ParameterizedTest
	@DisplayName("1. select with name like query")
	@ValueSource(strings = "D")
	@Order(4)
	void test4(String name) {
		
		var list = dao.findByNameLike(name);
		assertEquals(2, list.size());
		
	}
	
	
	
}


















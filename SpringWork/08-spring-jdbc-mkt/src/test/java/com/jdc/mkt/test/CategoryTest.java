package com.jdc.mkt.test;

import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.config.ApplicationConfig;
import com.jdc.mkt.dto.Category;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class CategoryTest {

	@Autowired
	private JdbcOperations jdbc;
	
	@Autowired
	private SimpleJdbcInsert insert;
	
	@Test
	@Order(1)
	void test1(@Value("${c.insert}") String sql) {
		
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[] {"Foods"});
		list.add(new Object[] {"Drinks"});
		list.add(new Object[] {"Snacks"});
		insert.getJdbcTemplate().batchUpdate(sql,list);   // insert can give JdbcTemplate.
	}
	
	@Test
	@Order(2)
	@DisplayName("2. generate id with creatory factory")
	void test2(@Value("${c.insert}") String sql) {
		
		var factory = new PreparedStatementCreatorFactory(sql,Types.VARCHAR);
		factory.setReturnGeneratedKeys(true);
		var creator = factory.newPreparedStatementCreator(List.of("Other"));
		var key = new GeneratedKeyHolder();
		
		jdbc.update(creator,key);
		var id = key.getKey().intValue();
		System.out.println(id);
	}
	
	
	@Test
	@DisplayName("3.simple jdbc insert")
	void test3(@Value("${c.insert}") String sql) {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Accessores");
		var id = insert.executeAndReturnKey(map);
		System.out.println(id);
	}
	
}











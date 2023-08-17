package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.config.ApplicationConfig;
import com.jdc.mkt.dto.Product;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class ProductTest {

	@Autowired
	private SimpleJdbcInsert insert;
	
	@Test
	@Sql(statements = {
			"insert into category (name) values ('Fruits')",
			"insert into category (name) values ('Drinks')",
			"insert into product (name,price,cat_id) values ('Orange',2000,1)",
			"insert into product (name,price,cat_id) values ('Apple',2400,1)",
			"insert into product (name,price,cat_id) values ('OrangeJuice',8000,2)"
			
	})
	
	void test2(@Value("${p.findById}")  String sql) {
		var mapper = new BeanPropertyRowMapper<Product>(Product.class);
		
		var p = insert.getJdbcTemplate().queryForObject(sql, mapper,1);
		System.out.println(p.getCategory());
	}
}

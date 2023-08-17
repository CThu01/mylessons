package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.config.ApplicationConfig;
import com.jdc.mkt.dto.Person;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class PersonTestTwo {

	@Autowired
	private JdbcOperations jdbc;

	@Autowired
	private RowMapper<Person> rowMapper;

	@Test
	@DisplayName("1. using query with ResultSetExtractor ")
	@Order(1)
	void test1() {
		var list = jdbc.query("select * from person", rs -> {
			List<Person> persons = new ArrayList<Person>();

			while (rs.next()) {
				var p = new Person();
				p.setName(rs.getString("name"));
				p.setId(rs.getInt("id"));
				p.setAge(rs.getInt("age"));
				persons.add(p);
			}
			return persons;
		});

		assertEquals(1, list.size());
	}

	@Test
	@DisplayName("2. using query with RollCallBackHandler ")
	@Order(2)
	void test2() {
		List<Person> persons = new ArrayList<Person>();

		jdbc.query("select * from person", rs -> {
			var p = new Person();
			p.setName(rs.getString("name"));
			p.setId(rs.getInt("id"));
			p.setAge(rs.getInt("age"));
			persons.add(p);
		});

		assertEquals(1, persons.size());
	}

	@Test
	@DisplayName("3. using query with RollMapper")
	@Order(3)
	void test3() {

//		var rowMapper = new BeanPropertyRowMapper<Person>(Person.class);
		var list = jdbc.query("select * from person", rowMapper);

		assertEquals(1, list.size());
	}

}

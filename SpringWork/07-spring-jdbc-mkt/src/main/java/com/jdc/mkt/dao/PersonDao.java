package com.jdc.mkt.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {

	private JdbcTemplate template;
	public String name;

	public PersonDao(JdbcTemplate template) {
		super();
		this.template = template;
	}

	public int insertPerson(String name, int age) {
		return template.update("insert into person (name,age) values (?,?)", name, age);
	}

}

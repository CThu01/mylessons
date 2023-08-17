package com.jdc.mkt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
//@ComponentScan(basePackages = {"com.jdc.mkt.dao"})
@PropertySource("/testdb.properties")
public class ApplicationConfig {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		
		builder.setType(EmbeddedDatabaseType.HSQL);
		builder.addScript("classpath:/ddlTestdb.sql");
		return builder.build();
	}
	
	@Bean
	public JdbcOperations template(DataSource dataSource) {
		return new JdbcTemplate(dataSource,true);
	}
	
	
	@Bean
	public SimpleJdbcInsert simpleJdbcInsert(DataSource dataSource) {
		var insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("category");
		insert.setGeneratedKeyName("id");
		return insert;
	}
	
	@Bean
	
	
}

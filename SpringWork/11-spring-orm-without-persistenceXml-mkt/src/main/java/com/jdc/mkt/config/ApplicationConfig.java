package com.jdc.mkt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "com.jdc.mkt.repo")
@PropertySource("/connection.properties")
@EnableTransactionManagement
public class ApplicationConfig {
	
	DataSource dataSource() {
		EmbeddedDatabaseBuilder dataSource = new EmbeddedDatabaseBuilder();
		dataSource.setType(EmbeddedDatabaseType.HSQL);
		return dataSource.build();
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("com.jdc.mkt.entity");
		emf.setJpaPropertyMap(jpaProperties());
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emf;
	}
	
	private Map<String, Object> jpaProperties() {
		Map<String,Object> map = new HashMap<>();
		map.put("hibernate.dbm2ddl.auto", "create");
		map.put("hibernate.show_sql", true);
		map.put("hibernate.format_sql", true);
		return map;
	}

	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
}

package com.jdc.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jdc.hello.beans.Employee;

@Configuration
@ComponentScan(basePackages = "com.jdc.hello.beans")
public class AppConfig {
	
//	@Bean
//	public Employee employeeBean() {
//		return new Employee("Tut Pi","idiot@gmail.com");
//	}
	
	@Bean({"int1,int2,int2"})
	public Integer helloBean() {
		return 10;
	}
}

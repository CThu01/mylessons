package com.jdc.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

import com.jdc.di.beans.MyClient;
import com.jdc.di.beans.MyCustomService;
import com.jdc.di.beans.MyDefaultService;
import com.jdc.di.beans.MyService;

import jakarta.annotation.Priority;

@Configuration
public class DIConfig {

	@Bean
	MyClient myClient(MyService service) {
		return new MyClient(service);
	}
	
	@Bean
//	@Order(1)  @priority (not work in java base)
//	@Primary
	MyService defaultmyService() {
		return new MyDefaultService();
	}
	
	@Bean
//	@Order(2)	@priority (not work in java base)
	MyService customService() {
		return new MyCustomService();
	}
	
}

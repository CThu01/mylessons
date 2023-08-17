package com.jdc.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan()
public class ScopeConfig {

	@Bean
	@Scope("prototype")
	public MyBean myBean() {
		return new MyBean();
	}
}

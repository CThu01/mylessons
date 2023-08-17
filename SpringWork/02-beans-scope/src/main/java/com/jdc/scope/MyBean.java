package com.jdc.scope;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("singleton")
public class MyBean implements InitializingBean,DisposableBean{
	
	public MyBean() {
		System.out.println("Default Constructor");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("afterPropertiesSet()");
		
	}
	
	void initMethod() {
		System.out.println("initMethod()");
	}
	
	@PreDestroy
	void beforeDestory() {
		System.out.println("PreDestory()");
	}
	
	@PostConstruct
	void afterCreate() {
		System.out.println("PostConstruct()");
	}

	@Override
	public void destroy() throws Exception {
		
		System.out.println("Disposable.destory()");
		
	}
	
	void customeDestroy() {
		System.out.println("Custom Destory");
	}
	
	
	
//	private String message;
//	
//	public MyBean() {
//		
//	}
//	
//	public MyBean(String message) {
//		this.message = message;
//	}
//	
//	public String getMessage() {
//		return message;
//	}
}

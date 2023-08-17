package com.jdc.di.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.di.DIConfig;
import com.jdc.di.beans.MyClient;

//@SpringJUnitConfig(locations = "classpath:/di.xml")
public class DependencyInjectionTest {

//	@Autowired
//	MyClient client;
	
	
	@Test
	void test() {
//		client.request();
		
		try(
//			var context = new GenericXmlApplicationContext("classpath:/di.xml")
			var context = new AnnotationConfigApplicationContext("com.jdc.di.beans")
//			var context = new AnnotationConfigApplicationContext(DIConfig.class)
			){
			
			var bean = context.getBean(MyClient.class);
			bean.request();
		}
	}
	
	
}

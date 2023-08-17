package com.jdc.hello.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jdc.hello.beans.Employee;

public class XmlConfigTest {

	@Test
	void test() {
		
		var context = new ClassPathXmlApplicationContext();
		
		context.setConfigLocation("classpath:/hello.xml");
		context.refresh();
		
		var bean = context.getBean(Employee.class);
		
		System.out.println("%s : %s".formatted(bean.getName(),bean.getEmail()));
		
		var str = context.getBean(String.class);
		System.out.println(str);
		
		context.close();
//		
	}
}

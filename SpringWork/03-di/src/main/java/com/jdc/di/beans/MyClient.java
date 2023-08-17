package com.jdc.di.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyClient {

	private MyService service;

//	@Autowired
	public MyClient(@Qualifier("custom")MyService service) {
//		super();
		this.service = service;
	}
	
	public void request() {
		service.doService();
	}

//	public MyService getService() {
//		return service;
//	}

//	@Autowired
//	public void setCustomService(MyService service) {
//		if(null != service) {
//			this.service = service;
//		}
//		
//	}
	
	
	
	
}

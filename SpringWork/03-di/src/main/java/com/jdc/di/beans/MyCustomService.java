package com.jdc.di.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.jdc.di.beans.qualifier.DIQualifier;
import com.jdc.di.beans.qualifier.QualifyType;

import jakarta.annotation.Priority;

@Component
//@Priority(198797978)
//@Qualifier("custom")
@DIQualifier(QualifyType.THREE)
public class MyCustomService implements MyService{

	@Override
	public void doService() {
		System.out.println("My Cutomer Service...");
	}

}

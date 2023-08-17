package com.jdc.di.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jdc.di.beans.qualifier.DIQualifier;
import com.jdc.di.beans.qualifier.QualifyType;

import jakarta.annotation.Priority;

@Component
//@Priority(99797)
//@Qualifier("defult")
@DIQualifier(QualifyType.ONE)
public class MyDefaultService implements MyService{

	@Override
	public void doService() {
		System.out.println("My default Service....");
	}

}

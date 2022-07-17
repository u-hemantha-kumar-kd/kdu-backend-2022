package com.hemanth.codes.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
		context.getBean(AppicationWithAnnotation.class).callTeachingMethods();
	}
}

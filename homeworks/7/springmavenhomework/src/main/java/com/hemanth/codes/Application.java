package com.hemanth.codes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student student = (Student) context.getBean("student");
		Student studentTwo = (Student) context.getBean("studentTwo");
		Branch branch = (Branch) context.getBean("branch");

		System.out.println(student);
		System.out.println(branch);
		context.registerShutdownHook();

	}
}

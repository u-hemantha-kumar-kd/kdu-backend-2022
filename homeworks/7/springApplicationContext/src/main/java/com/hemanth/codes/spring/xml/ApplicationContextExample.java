package com.hemanth.codes.spring.xml;

import com.hemanth.codes.PhysicsTeacher;
import com.hemanth.codes.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExample {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Application application = applicationContext.getBean(Application.class);
		PhysicsTeacher physicsTeacher = (PhysicsTeacher) applicationContext.getBean("physicsTeacher");
		PhysicsTeacher physicsTeacher1 = (PhysicsTeacher) applicationContext.getBean("physicsTeacher");
		System.out.println(physicsTeacher == physicsTeacher1);
		physicsTeacher.teach();

		physicsTeacher = (PhysicsTeacher) applicationContext.getBean("physicsTeacher1");
		physicsTeacher1 = (PhysicsTeacher) applicationContext.getBean("physicsTeacher1");
		System.out.println(physicsTeacher == physicsTeacher1);

		application.callTeachMethods();

	}
}
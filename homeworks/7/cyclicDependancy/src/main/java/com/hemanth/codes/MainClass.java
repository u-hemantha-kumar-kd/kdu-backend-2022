package com.hemanth.codes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		FileOne file1 = (FileOne) context.getBean(FileOne.class);
		FileTwo file2 = (FileTwo) context.getBean(FileTwo.class);
	}
}

package com.homework14.part2;

import com.homework14.part2.service.TeacherServiceImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        TeacherServiceImplementation service = context.getBean(TeacherServiceImplementation.class);
        service.save();
        service.findAll();
    }
}
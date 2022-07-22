package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.validation.*;
import java.util.*;

public class applicationConfigMain {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(applicationConfig.class);
        Employee employee = (Employee) context.getBean("employee");
        String name = employee.getName();
        System.out.println("Employee Name: "+name);
        System.out.println("Employee DOB: "+employee.getDob());
        System.out.println("Employee Role: "+employee.getRole());

        Validator validator = context.getBean(Validator.class);
        dobValidator user = context.getBean(dobValidator.class);
        Set<ConstraintViolation<dobValidator>> violations = validator.validate(user);
        for (ConstraintViolation<dobValidator> violation : violations) {
            System.err.println(violation.getMessage());
        }
    }
}

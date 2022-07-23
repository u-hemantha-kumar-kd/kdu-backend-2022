package com.homework14.part2;

import com.homework14.part2.service.TeacherServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.homework14.part2.service"})
public class JpaConfig {
    @Autowired
    private TeacherServiceImplementation service;

    public void save(){
        service.save();
    }

    public void findAll(){
        System.out.println(service.findAll());
    }
}

package com.example.demo;

import lombok.*;
import org.springframework.context.annotation.*;

@Configuration
@Data
@AllArgsConstructor
@ComponentScan
public class applicationConfig {

    @Bean("employee")
    public Employee MyEmployee(){
        return new Employee("U Hemantha Kumar","11/01/2001", "Software Developer");
    }
}

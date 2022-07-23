package com.kd.backend.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootApplicationDemo {

    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(SpringBootApplicationDemo.class, args);
    }
}

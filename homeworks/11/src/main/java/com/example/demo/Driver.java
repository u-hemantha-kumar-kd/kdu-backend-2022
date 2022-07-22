package com.example.demo;

import com.example.demo.anotherUtilPackage.BuyProduct;
import com.example.demo.authPackage.Authentication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Authentication authObj = context.getBean(Authentication.class);
        authObj.signIn("12345");
        authObj.signIn("1234");
        BuyProduct buyObj = context.getBean(BuyProduct.class);
        buyObj.buyProduct("sugar", 5, 200);
        buyObj.buyProduct("Oil", -5, 50);
    }
}

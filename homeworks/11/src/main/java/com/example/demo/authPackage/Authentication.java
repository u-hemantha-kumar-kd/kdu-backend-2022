package com.example.demo.authPackage;

import org.springframework.stereotype.Component;

@Component
public class Authentication {
    public boolean signIn(String token)
    {
        if(token.equals("12345"))
        {
            System.out.println("Login Successful!");
            return true;
        }
        if (token.length() < 5)throw new IllegalArgumentException("Please provide a token of length 5...!");
        System.out.println("Login Failed!");
        return false;
    }
}

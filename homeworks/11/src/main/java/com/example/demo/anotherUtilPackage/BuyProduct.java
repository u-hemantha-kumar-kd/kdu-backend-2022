package com.example.demo.anotherUtilPackage;

import org.springframework.stereotype.Component;

@Component
public class BuyProduct {
    public boolean buyProduct(String product, int volume, int balance)
    {
        int transaction_amount = 100;
        if(volume < 0)
        {
            throw new IllegalArgumentException("Volume of coins should not be negative...!");
        }
        if(balance < transaction_amount)
        {
            System.out.println("Low Balance...!");
            return false;
        }
        System.out.println("Bought coins successfully");
        return true;
    }
}

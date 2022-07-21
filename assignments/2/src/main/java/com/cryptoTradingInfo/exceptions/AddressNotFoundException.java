package com.cryptoTradingInfo.exceptions;


//this is a custom Exception class , which is raised when the wallet address entered by the user is not a valid one
public class AddressNotFoundException extends Exception {
    public AddressNotFoundException(String s)
    {
        super(s);
    }
}

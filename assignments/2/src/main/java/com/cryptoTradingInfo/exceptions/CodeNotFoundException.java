package com.cryptoTradingInfo.exceptions;


//this is the custom exception class used when the code of the coin entered by the user is not valid
public class CodeNotFoundException extends Exception{
    public CodeNotFoundException(String s)
    {
        super(s);
    }
}

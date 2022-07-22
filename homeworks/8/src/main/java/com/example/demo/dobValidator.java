package com.example.demo;

import org.springframework.stereotype.Component;
import javax.validation.*;

@Component
public class dobValidator implements ConstraintValidator<dobValidation, String> {

    @Override
    public boolean isValid(String dob, ConstraintValidatorContext context){
        String [] date_splits = dob.split("/");

        if(Integer.parseInt(date_splits[0]) > 30 || Integer.parseInt(date_splits[1]) > 12 || Integer.parseInt(date_splits[0]) < 0 || Integer.parseInt(date_splits[1]) < 0)
            return false;

        return true;
    }
}

package com.example.demo;

import javax.validation.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

@Target({FIELD,PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = dobValidator.class)
public @interface dobValidation {
    public String message() default "{Invalid DOB}";
}

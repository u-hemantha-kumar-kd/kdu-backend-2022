package com.example.demo;

import lombok.*;

@AllArgsConstructor
@Data
public class Employee {
    private String name;
    @dobValidation
    private String dob;
    private String role;
}

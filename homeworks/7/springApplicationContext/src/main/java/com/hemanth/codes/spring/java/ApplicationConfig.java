package com.hemanth.codes.spring.java;

import com.hemanth.codes.PhysicsTeacher;
import com.hemanth.codes.Teacher;
import com.hemanth.codes.MathematicsTeacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class ApplicationConfig {

    @Bean(name = "myPhysicsTeacher")
    @Scope("singleton")
    public Teacher createPhysicsTeacher() {
        return new PhysicsTeacher();
    }

    @Bean(name = "myMathematicsTeacher")
    public MathematicsTeacher createMathematicsTeacher() {
        return new MathematicsTeacher();
    }

    
}
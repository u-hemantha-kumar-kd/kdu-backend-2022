package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

//    using args point-cut designator
//    @Pointcut("execution(public * *(..))")


//    using within point-cut designator to use AOP within the Authentication class and not other classes
    @Pointcut("within(com.example.demo.authPackage.Authentication)")
    public void anyPublicMethod() {
    }


    @Before("anyPublicMethod()")
    public void logBeforeAdd(JoinPoint joinPoint) {
        System.out.println("Before : " + joinPoint.getSignature().getName());
    }


    @After("anyPublicMethod()")
    public void logAfterAdd(JoinPoint joinPoint) {
        System.out.println("After : " + joinPoint.getSignature().getName());
    }


    @Around("anyPublicMethod()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around-Before : " + pjp.getSignature().getName());
        Object returned = null;
        try {
            returned = pjp.proceed();
            System.out.println("Returned: " + returned);
        } catch (Throwable throwable) {
//            throwable.printStackTrace();
            throw throwable;
        }
        System.out.println("Around-After : " + pjp.getSignature().getName());
        return returned;
    }


    @AfterReturning(pointcut = "anyPublicMethod()", returning = "result")
    public void logAfterReturn(JoinPoint joinPoint, Object result) {
        System.out.println("After Return " + result);
    }

    @AfterThrowing(pointcut = "anyPublicMethod()", throwing = "ex")
    public void logAfterReturn(JoinPoint joinPoint, Throwable ex) {
        System.out.println("After Throw " + ex);
    }
}

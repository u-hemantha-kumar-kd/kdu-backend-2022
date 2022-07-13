package io.javabrains;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    // Run once, e.g. Database connection, connection pool
    @BeforeAll
    public static void runOnceBeforeAllTests() {
        System.out.println("@BeforeAll - runOnceBeforeTesting");
    }

    // Run once, e.g close connection, cleanup
    @AfterAll
    public static void runOnceAfterAllTests() {
        System.out.println("@AfterAll - runOnceAfterTesting");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @BeforeEach
    public void runBeforeTestMethod() {
        System.out.println("@BeforeEach - runBeforeEachTestMethod");
    }

    // Should rename to @AfterTestMethod
    @AfterEach
    public void runAfterTestMethod() {
        System.out.println("@AfterEach - runAfterEachTestMethod");
    }

    @Test
    void testAdd(){
        Calculator obj = new Calculator();
        int expected = 4;
        int actual = obj.add(2, 2);
        System.out.println("Add Test");
        assertEquals(expected, actual, "Add function is expected to add two numbers");
    }

    @Test
    void testSubtract(){
        Calculator obj = new Calculator();
        double expected = -10;
        double actual =  obj.subtract(10, 20);
        System.out.println("Subtract Test");
        assertEquals(expected, actual, "Should return correct value after Subtraction");
    }

    @Test
    void testDivide(){
        Calculator obj = new Calculator();
        System.out.println("Divide Test");
        assertThrows(ArithmeticException.class, () -> obj.divide(1, 0), "Divide by zero throws Arithmetic Exception")
        ;
    }


    @Test
    void testMultiply(){
        Calculator obj = new Calculator();
        int expected = 20;
        int actual = obj.multiply(10, 2);
        System.out.println("Multiply Test");
        assertEquals(expected, actual, "multiply method should return correct value");
    }
}

package com.test.andy.springboottest.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calculatorService.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculatorService.divide(6, 3));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(6, 0));
    }
}

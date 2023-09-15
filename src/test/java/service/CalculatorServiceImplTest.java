package service;

import exception.DivisionByZeroException;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import static service.Constans.*;

class CalculatorServiceImplTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    public void shouldReturnTwoWhenSumOneAndOne() {
        int result = calculatorService.plus(ONE, ONE);
        assertEquals(ONE + ONE, result);
    }

    @Test
    public void shouldReturnThreeWhenSumTwoAndOne() {
        int result = calculatorService.plus(TWO, ONE);
        assertEquals(TWO + ONE, result);
    }

    @Test
    public void shouldReturnOneWhenMinusTwoAndOne() {
        int result = calculatorService.minus(TWO, ONE);
        assertEquals(TWO - ONE, result);
    }

    @Test
    public void shouldReturnZeroWhenMinusOneAndOne() {
        int result = calculatorService.minus(ONE, ONE);
        assertEquals(ONE - ONE, result);
    }

    @Test
    public void shouldReturnTwoWhenMultiplicationOneAndTwo() {
        int result = calculatorService.multiplication(ONE, TWO);
        assertEquals(ONE * TWO, result);
    }

    @Test
    public void shouldReturnOneWhenMultiplicationOneAndOne() {
        int result = calculatorService.multiplication(ONE, ONE);
        assertEquals(ONE * ONE, result);
    }
    @Test
    public void shouldReturnTwoWhenDivisionTwoAndOne() {
        int result = calculatorService.division(TWO, ONE);
        assertEquals(TWO / ONE, result);
    }

    @Test
    public void shouldReturnOneWhenDivisionOneAndOne() {
        int result = calculatorService.division(ONE, ONE);
        assertEquals(ONE / ONE, result);
    }

    @Test
    public void shouldThrowDivisionByZeroExceptionWhenDivideByZero() {
        assertThrows(DivisionByZeroException.class, () -> calculatorService.division(ONE, ZERO));
    }




}
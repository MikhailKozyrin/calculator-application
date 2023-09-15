package service;

import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static service.Constans.*;

public class CalculatorServiceImplParamTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("provideCalculatorParams")
    public void shouldSumCorrectly(int a, int b) {
        int result = calculatorService.plus(a, b);
        Assertions.assertEquals(a + b, result);
    }
    @ParameterizedTest
    @MethodSource("provideCalculatorParams")
    public void shouldMinusCorrectly(int a, int b) {
        int result = calculatorService.minus(a, b);
        Assertions.assertEquals(a - b, result);
    }
    @ParameterizedTest
    @MethodSource("provideCalculatorParams")
    public void shouldMultiplicationCorrectly(int a, int b) {
        int result = calculatorService.multiplication(a, b);
        Assertions.assertEquals(a * b, result);
    }
    @ParameterizedTest
    @MethodSource("provideCalculatorParams")
    public void shouldDivisionCorrectly(int a, int b) {
        int result = calculatorService.division(a, b);
        Assertions.assertEquals(a / b, result);
    }

    private static Stream<Arguments> provideCalculatorParams() {
        return Stream.of(
                Arguments.of(ONE, TWO),
                Arguments.of(TWO, TWO),
                Arguments.of(ONE, THREE),
                Arguments.of(ZERO, THREE)
        );
    }

}

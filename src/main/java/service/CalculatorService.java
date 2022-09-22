package service;

import org.springframework.stereotype.Service;
@Service
public class CalculatorService implements CalculatorServiceInt {

    @Override
    public int plus(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public int minus(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public int multiplication(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public int division(Integer a, Integer b) {
        if (b == 0) throw new IllegalArgumentException("Делить на ноль нельзя");
        return (int) ((double) a / b);
    }

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }
}

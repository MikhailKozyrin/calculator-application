package service;

import exception.DivisionByZeroException;
import org.springframework.stereotype.Service;
@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public int multiplication(int a, int b) {
        return a * b;
    }

    @Override
    public int division(int a, int b) {
        if (b == 0) {
            throw new DivisionByZeroException();
        }
        return a / b;
    }

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }
}

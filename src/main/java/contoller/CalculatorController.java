package contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    public CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return calculatorService.welcome();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "значение не передано";
        int plus = calculatorService.plus(a, b);
        return a + " + " + b + " = " + plus;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "значение не передано";
        int minus = calculatorService.minus(a, b);
        return a + " - " + b + " = " + minus;
    }

    @GetMapping("/multiplication")
    public String multiple(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "значение не передано";
        int multiple = calculatorService.multiplication(a, b);
        return a + " * " + b + " = " + multiple;
    }

    @GetMapping("/division")
    public String division(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "значение не передано";
        double division;
        try {
            division = calculatorService.division(a, b);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return a + " * " + b + " = " + division;
    }
}


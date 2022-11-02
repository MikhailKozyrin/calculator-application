package contoller;

import exception.DivisionByZeroException;
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
    public String plus(@RequestParam int a,
                       @RequestParam int b) {
        return generateMessage(a, b, "+", calculatorService.plus(a, b));
    }

    @GetMapping("/minus")
    public String minus(@RequestParam int a,
                        @RequestParam int b) {
        return generateMessage(a, b, "-", calculatorService.minus(a, b));
    }

    @GetMapping("/multiplication")
    public String multiple(@RequestParam int a,
                           @RequestParam int b) {
        return generateMessage(a, b, "*", calculatorService.multiplication(a, b));
    }

    @GetMapping("/division")
    public String division(@RequestParam int a, @RequestParam int b) {
                return generateMessage(a, b, "/", calculatorService.division(a, b));

    }

    private String generateMessage(int a, int b, String operation, int result) {
        return String.format("%d %s %d = %d", a, operation, b, result);
    }
}

package com.test.andy.springboottest.controller.test;


import com.test.andy.springboottest.service.CalculatorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculation")
@Tag(name = "單元測試用")
public class CalculationController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public int add(int a, int b) {
        return calculatorService.add(a, b);
    }

    @GetMapping("/subtract")
    public int subtract(int a, int b) {
        return calculatorService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public int multiply(int a, int b) {
        return calculatorService.multiply(a, b);
    }


    @GetMapping("/divide")
    public int divide(int a, int b) {
        return calculatorService.divide(a, b);
    }
}

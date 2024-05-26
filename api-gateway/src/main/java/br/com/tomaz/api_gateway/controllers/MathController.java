package br.com.tomaz.api_gateway.controllers;


import br.com.tomaz.api_gateway.convertes.NumberConverter;
import br.com.tomaz.api_gateway.math.SimpleMath;
import org.springframework.web.bind.annotation.*;



@RestController
public class MathController {

    SimpleMath math = new SimpleMath();


    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {

        NumberConverter.numericVerify(numberOne, numberTwo);

        return math.sum(numberOne, numberTwo);
    }


    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {

        NumberConverter.numericVerify(numberOne, numberTwo);

        return math.division(numberOne, numberTwo);
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {

        NumberConverter.numericVerify(numberOne, numberTwo);

        return math.multiplication(numberOne, numberTwo);
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {

        NumberConverter.numericVerify(numberOne, numberTwo);

        return math.subtraction(numberOne, numberTwo);
    }

    @GetMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable String number) {
        NumberConverter.numericVerify(number);

        return math.squareRoot(number);
    }
}

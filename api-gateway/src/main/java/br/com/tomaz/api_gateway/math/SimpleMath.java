package br.com.tomaz.api_gateway.math;

import br.com.tomaz.api_gateway.convertes.NumberConverter;

public class SimpleMath {

    public Double sum(String numberOne, String numberTwo) {
        return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {

        return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
    }

    public Double squareRoot(String number) {
        return Math.sqrt(NumberConverter.convertToDouble(number));
    }
}

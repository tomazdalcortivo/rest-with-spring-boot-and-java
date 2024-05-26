package br.com.tomaz.api_gateway.convertes;

import br.com.tomaz.api_gateway.exceptions.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static boolean numericVerify(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please put a numeric value");
        }
        return true;
    }
    public static boolean numericVerify(String numberOne) {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please put a numeric value");
        }
        return true;
    }
}

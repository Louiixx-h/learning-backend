package br.com.luislabs.restwithspringbootandjavaerudio.utils;

public class NumberHandler {
    public static Double toDouble(String number) {
        if (number == null) return 0D;
        String formattedNumber = number.replaceAll(",", ".");
        if (isNumeric(formattedNumber)) {
            return Double.parseDouble(formattedNumber);
        } else {
            return 0D;
        }
    }

    public static boolean isNumeric(String number) {
        if (number == null) return false;
        String formattedNumber = number.replaceAll(",", ".");
        return formattedNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}

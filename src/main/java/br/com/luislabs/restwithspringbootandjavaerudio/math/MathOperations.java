package br.com.luislabs.restwithspringbootandjavaerudio.math;

public class MathOperations {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double divide(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double times(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double subtract(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }
}

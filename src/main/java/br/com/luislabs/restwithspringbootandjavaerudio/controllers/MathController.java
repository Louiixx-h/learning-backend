package br.com.luislabs.restwithspringbootandjavaerudio.controllers;

import br.com.luislabs.restwithspringbootandjavaerudio.exceptions.UnsupportedMathOperationException;
import br.com.luislabs.restwithspringbootandjavaerudio.math.MathOperations;
import org.springframework.web.bind.annotation.*;

import static br.com.luislabs.restwithspringbootandjavaerudio.utils.NumberHandler.isNumeric;
import static br.com.luislabs.restwithspringbootandjavaerudio.utils.NumberHandler.toDouble;

@RestController
public class MathController {

    private final MathOperations math = new MathOperations();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.sum(toDouble(numberOne), toDouble(numberTwo));
    }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divide(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.divide(toDouble(numberOne), toDouble(numberTwo));
    }

    @RequestMapping(value = "/times/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double times(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.times(toDouble(numberOne), toDouble(numberTwo));
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.subtract(toDouble(numberOne), toDouble(numberTwo));
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(
        @PathVariable(value = "number") String number
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.squareRoot(toDouble(number));
    }
}

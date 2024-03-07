package pe.com.saldivar.math

import org.springframework.web.bind.annotation.PathVariable
import pe.com.saldivar.controller.converters.NumberConverter
import pe.com.saldivar.exceptions.UnsupportedMathOperationException
import kotlin.math.sqrt

class SimpleMath {
    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo
    fun subtraction(numberOne: Double, numberTwo: Double) = numberOne - numberTwo
    fun multiplication(numberOne: Double, numberTwo: Double) = numberOne * numberTwo
    fun division(numberOne: Double, numberTwo: Double) = numberOne / numberTwo
    fun mean(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo) / 2
    fun squareRoot(numberOne: Double) = sqrt(numberOne)
}
package Tarea1

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

abstract class AbstractPerceptronTest

lateinit var pesos: ArrayList<Double>
var inputs11 = listOf(1, 1)
var inputs10 = listOf(1, 0)
var inputs01 = listOf(0, 1)
var inputs00 = listOf(0, 0)

@BeforeEach
fun setUp() {

}

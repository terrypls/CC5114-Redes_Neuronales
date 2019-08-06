package Tarea1

import org.junit.jupiter.api.BeforeEach

abstract class AbstractPerceptronTest

lateinit var pesos: List<Double>
var inputs11 = listOf(1, 1)
var inputs10 = listOf(1, 0)
var inputs01 = listOf(0, 1)
var inputs00 = listOf(0, 0)
var tolerancia = 0.00001

@BeforeEach
fun setUp() {

}

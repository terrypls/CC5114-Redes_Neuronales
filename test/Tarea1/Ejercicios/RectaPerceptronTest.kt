package Tarea1.Ejercicios

import Tarea1.AbstractPerceptronTest
import Tarea1.pesos

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RectaPerceptronTest : AbstractPerceptronTest() {

    @Test
    fun training() {
        pesos = arrayListOf(-2.0, -2.0)
        val perceptron = RectaPerceptron(pesos, 3.0)

        perceptron.learning(listOf(1, 1), 0)
        assertEquals(3.0, perceptron.bias)

        perceptron.learning(listOf(0,0),0)
        assertNotEquals(3.0,perceptron.bias)
    }
}
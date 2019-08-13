package Tarea1.Ejercicios

import Tarea1.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RectaPerceptronTest : AbstractPerceptronTest() {

    @Test
    fun learnign() {
        pesos = arrayOf(-2.0, -2.0)
        val perceptron = RectaPerceptron(pesos, 3.0)

        perceptron.learning(listOf(1, 1), 0)
        assertEquals(3.0, perceptron.bias)

        perceptron.learning(listOf(1,0),0)
        assertNotEquals(3.0,perceptron.bias)
        assertNotEquals(-2.0,perceptron.pesos[0])
    }
    @Test
    fun training(){
        pesos = arrayOf(-2.0,-2.0)
        val perceptron = RectaPerceptron(pesos,0.0)

        perceptron.training(inputs11,1)

        assertEquals(1,perceptron.procesador(inputs11))
        assertEquals(0,perceptron.procesador(inputs10))
        assertEquals(0,perceptron.procesador(inputs01))
        assertEquals(0,perceptron.procesador(inputs00))



    }
}
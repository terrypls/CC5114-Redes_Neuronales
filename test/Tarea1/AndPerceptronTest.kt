package Tarea1

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AndPerceptronTest:AbstractPerceptronTest() {


    @Test
    fun setBias() {
    }

    @Test
    fun procesador() {
        pesos = listOf(1.0, 3.0)
        val perceptron = AndPerceptron(pesos,tolerancia)
        assertEquals(1,perceptron.procesador(inputs11))
        assertEquals(0,perceptron.procesador(inputs00))
        assertEquals(0,perceptron.procesador(inputs01))
        assertEquals(0,perceptron.procesador(inputs10))

    }

    @Test
    fun learning() {
    }

    @Test
    fun calcBias() {
    }

    @Test
    fun getPesos() {
    }

    @Test
    fun getTolerance() {
    }

    @Test
    fun calcBias1() {
    }

    @Test
    fun getTolerancia() {
    }
}
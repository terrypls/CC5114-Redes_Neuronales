package Tarea1

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AndPerceptronTest {
    private lateinit var pesos:List<Double>
    private lateinit var inputs11:List<Int>
    private lateinit var inputs10:List<Int>
    private lateinit var inputs01:List<Int>
    private lateinit var inputs00:List<Int>
    private var tolerancia = 0.00001
    @BeforeEach
    fun setUp() {
        pesos = listOf(1.0,3.0)
        inputs11 = listOf(1,1)
        inputs10 = listOf(1,0)
        inputs01 = listOf(0,1)
        inputs00 = listOf(0,0)
    }

    @Test
    fun getBias() {
        var perceptron = AndPerceptron(pesos,tolerancia)
        assertEquals(2.0,perceptron.bias)
    }

    @Test
    fun setBias() {
    }

    @Test
    fun procesador() {
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
package Tarea1.Ejercicios


import Tarea1.*
import Tarea1.Perceptron.NandPerceptron
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NandNeuronTest : AbstractNeuronTest() {

    @Test
    fun procesador() {
        pesos = arrayOf(-2.0, -2.0)
        val perceptron = NandPerceptron(pesos, 3.0)
        assertEquals(0, perceptron.procesador(inputs11), "test 11")
        assertEquals(1, perceptron.procesador(inputs10), "test 10")
        assertEquals(1, perceptron.procesador(inputs01), "test 01")
        assertEquals(1, perceptron.procesador(inputs00), "test 00")
    }

}
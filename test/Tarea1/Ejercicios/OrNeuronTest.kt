package Tarea1.Ejercicios

import Tarea1.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class OrNeuronTest: AbstractNeuronTest() {

    @Test
    fun procesador() {
        pesos = arrayOf(2.0, 2.0)
        val perceptron = OrPerceptron(pesos, -1.0)

        assertEquals(1, perceptron.procesador(inputs11), "test 11")
        assertEquals(1, perceptron.procesador(inputs10),"test 10")
        assertEquals(1, perceptron.procesador(inputs01),"test 01")
        assertEquals(0, perceptron.procesador(inputs00),"test 00")

    }
}
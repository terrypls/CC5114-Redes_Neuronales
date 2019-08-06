package Tarea1


import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NandPerceptronTest : AbstractPerceptronTest() {


    @Test
    fun getBias() {

    }

    @Test
    fun procesador() {
        pesos = listOf(-2.0, -2.0)

        var perceptron = NandPerceptron(pesos, tolerancia)
        perceptron.bias=3.0
        assertEquals(0, perceptron.procesador(inputs11), "test 11,chupalo entonces")
        assertEquals(1, perceptron.procesador(inputs10),"test 10")
        assertEquals(1, perceptron.procesador(inputs01),"test 01")
        assertEquals(1, perceptron.procesador(inputs00),"test 00")
    }

    @Test
    fun calcBias() {
    }
}
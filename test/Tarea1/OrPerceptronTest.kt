package Tarea1

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class OrPerceptronTest:AbstractPerceptronTest() {

    @Test
    fun procesador() {
        pesos = listOf(2.0, 2.0)
        var perceptron = OrPerceptron(pesos, tolerancia)

        assertEquals(1, perceptron.procesador(inputs11), "test 11,chupalo entonces")
        assertEquals(1, perceptron.procesador(inputs10),"test 10")
        assertEquals(1, perceptron.procesador(inputs01),"test 01")
        assertEquals(0, perceptron.procesador(inputs00),"test 00")

    }
}
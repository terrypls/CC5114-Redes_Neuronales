package Tarea1.Ejercicios

import Tarea1.*
import Tarea1.Perceptron.AndNeurona
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AndNeuronTest : AbstractNeuronTest() {

    @Test
    fun setBias() {
    }

    @Test
    fun procesador() {
        pesos = arrayOf(1.0, 3.0)
        val perceptron = AndNeurona(pesos, -3.5)
        assertEquals(1, perceptron.procesador(inputs11),"test 11")
        assertEquals(0, perceptron.procesador(inputs10),"test 10")
        assertEquals(0, perceptron.procesador(inputs01),"test 01")
        assertEquals(0, perceptron.procesador(inputs00),"test 00")
    }

}
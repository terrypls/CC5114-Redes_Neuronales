package Tarea1.Ejercicios

import Tarea1.AbstractNeuronTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NandCircuitTest() : AbstractNeuronTest() {


    @Test
    fun suma() {
        val Circuit = NandCircuit()
        assertEquals(0, Circuit.suma(1, 1))
    }
}
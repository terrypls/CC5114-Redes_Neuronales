package Tarea1.Ejercicios

import Tarea1.AbstractPerceptronTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NandCircuitTest() : AbstractPerceptronTest() {


    @Test
    fun suma() {
        val Circuit = NandCircuit()
        assertEquals(0, Circuit.suma(1, 1))
    }
}
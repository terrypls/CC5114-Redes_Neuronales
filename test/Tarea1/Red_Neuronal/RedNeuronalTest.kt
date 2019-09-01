package Tarea1.Red_Neuronal

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RedNeuronalTest {
    private lateinit var red: RedNeuronal
    var l11 = listOf(1.0, 1.0)
    var l10 = listOf(1.0, .0)
    var l01 = listOf(.0, 1.0)
    var l00 = listOf(.0, .0)
    private var repeticiones = 100000
    @BeforeEach
    fun setUp() {
        red = RedNeuronal(2, listOf(5, 2), 2, 2)
    }


    @Test
    fun and() {
        assertEquals(0, red.data.size)
        red.agregarSet(l00, listOf(1.0,.0))
        red.agregarSet(l01, listOf(1.0,.0))
        red.agregarSet(l10, listOf(1.0,.0))
        red.agregarSet(l11, listOf(.0,1.0))
        red.entrenarRed(repeticiones)
        println(red.precision)
        assertEquals(1,red.elige(listOf(1.0,1.0)))
        assertEquals(0,red.elige(listOf(1.0,0.0)))
        assertEquals(0,red.elige(listOf(0.0,1.0)))
        assertEquals(0,red.elige(listOf(0.0,0.0)))




    }

    @Test
    fun or() {
    }

    @Test
    fun nand() {
    }

    fun xor() {}
}
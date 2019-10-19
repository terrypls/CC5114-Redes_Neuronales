package Tarea2.Genes

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MochilaGenTest {
    val opciones = arrayOf(
        Pair(0, 0),
        Pair(12, 4),
        Pair(2, 2),
        Pair(1, 2),
        Pair(1, 1),
        Pair(4, 10)
    )
    lateinit var mochilaGen: MochilaGen

    @BeforeEach
    fun setUp() {
        mochilaGen = MochilaGen(opciones)
    }

    @Test
    fun constructor() {
        println("${mochilaGen.alelo.first} ${mochilaGen.alelo.second}")
    }

    @Test
    fun copiarA() {
    }

    @Test
    fun copiarDesdeMochilaGen() {
    }

    @Test
    fun comparar() {
    }

    @Test
    fun copiarGen() {
    }

    @Test
    fun cambiarGen() {
    }
}
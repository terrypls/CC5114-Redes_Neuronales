package Tarea2.Cromosoma

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MochilaCromosomaTest {
    val opciones = arrayOf(
        Pair(0, 0),
        Pair(12, 4),
        Pair(2, 2),
        Pair(1, 2),
        Pair(1, 1),
        Pair(4, 10)
    )
    lateinit var cromosoma: MochilaCromosoma
    lateinit var mochilaCromosoma: MochilaCromosoma
    @BeforeEach
    fun setUp() {
        cromosoma = MochilaCromosoma(10, opciones, 36, 15)
    }

    @Test
    fun imprimir() {
        println(cromosoma.imprimir())
    }

    @Test
    fun fitness() {
        println(cromosoma.fitness())
    }
}
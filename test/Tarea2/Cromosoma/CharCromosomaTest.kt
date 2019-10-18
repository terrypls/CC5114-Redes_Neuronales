package Tarea2.Cromosoma

import Tarea2.Genes.CharGen
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class CharCromosomaTest {
    lateinit var cromosoma: CharCromosoma
    lateinit var cromosoma2: CharCromosoma
    lateinit var cromosoma3: CharCromosoma
    val alfabeto = "abcdefghijklmnopqrstuvwxyz"
    @BeforeEach
    fun setUp() {
        cromosoma = CharCromosoma(5, alfabeto, "bolso", null)
        cromosoma2 = CharCromosoma(5, alfabeto, "bolso", null)
    }

    @Test
    fun constructor() {
        cromosoma3 = CharCromosoma(2, alfabeto, "bolso", arrayOf(CharGen("bolso"), CharGen("bolso")))

    }

    @Test
    fun mutar() {
        val algo = cromosoma.imprimir()
        val cosa = cromosoma2.imprimir()
        cromosoma.mutar(.5)
        cromosoma2.mutar(.5)

        assertNotEquals(algo, cromosoma.imprimir())
        assertNotEquals(cosa, cromosoma2.imprimir())
        println("antes: ${algo} Despues: ${cromosoma.imprimir()}")
        println("antes: ${cosa} Despues: ${cromosoma2.imprimir()}")
    }

    @Test
    fun cambiarGenEn() {
        val algo = cromosoma.imprimir()

        cromosoma.cambiarGenEn(3, '7')

        println("antes: ${algo} Despues: ${cromosoma.imprimir()}")

    }

    @Test
    fun compararCromosoma() {

        val algo = cromosoma.imprimir()
        val cosa = cromosoma2.imprimir()
        assertTrue(cromosoma.compararCromosoma(cromosoma))
        assertFalse(cromosoma.compararCromosoma(cromosoma2))
    }

    @Test
    fun copiarCromosoa() {
        val aux = cromosoma.copiar()
        for (i in cromosoma.genes.indices) {
            assertEquals(aux.genes[i], cromosoma.genes[i])
        }
    }


}
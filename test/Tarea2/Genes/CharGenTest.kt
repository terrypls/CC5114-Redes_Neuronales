package Tarea2.Genes

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CharGenTest {
    lateinit var gen: CharGen
    lateinit var gen2: CharGen
    lateinit var gen3: CharGen
    lateinit var genA: CharGen
    lateinit var genAA: CharGen
    lateinit var genB: CharGen
    @BeforeEach
    fun setUp() {
        gen = CharGen("abcde")
        gen2 = CharGen("abcde")
        gen3 = CharGen("fghij")
        genA = CharGen("abcde", 'a')
        genAA = CharGen("abcde", 'a')
        genB = CharGen("abcde", 'b')
    }

    @Test
    fun copiarA() {
        val alelo1 = gen.alelo
        val alelo2 = gen2.alelo

        gen.copiarA(gen2)

        assertEquals(alelo1, gen2.alelo)
    }
    @Test
    fun comparar() {
        assertTrue(genA.comparar(genAA))
        assertFalse(genA.comparar(genB))
    }

    @Test
    fun cambiarGen() {
        assertEquals('a', genA.alelo)
        genA.cambiarGen('b')
        assertEquals('b', genA.alelo)
    }

    @Test
    fun copiarGen() {
        val aux = genA.copiarGen()
        assertEquals(aux.alelo, genA.alelo)
    }
}
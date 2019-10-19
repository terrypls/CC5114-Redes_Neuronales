package Tarea2

import Tarea2.Cromosoma.CharCromosoma
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IndividuoTest {

    lateinit var individuo: Individuo
    lateinit var individuo2: Individuo
    lateinit var cromosoma: CharCromosoma
    lateinit var cromosoma2: CharCromosoma
    val alfabeto = "abcdefghijklmnopqrstuvwxyz"
    @BeforeEach
    fun setUp() {
        cromosoma = CharCromosoma(5, alfabeto, "bolso", null)
        cromosoma2 = CharCromosoma(5, alfabeto, "bolso", null)
        individuo = Individuo(cromosoma, 0.5)
        individuo2 = Individuo(cromosoma2, 0.5)
    }

    @Test
    fun crossover() {
    }

    @Test
    fun mutar() {
        val algo = cromosoma.imprimir()
        val cosa = cromosoma2.imprimir()
        individuo2.mutar()
        individuo.mutar()
        assertNotEquals(algo, cromosoma.imprimir())
        assertNotEquals(cosa, cromosoma2.imprimir())
        println("antes: $algo Despues: ${cromosoma.imprimir()}")
        println("antes: $cosa Despues: ${cromosoma2.imprimir()}")
    }

    @Test
    fun charFitness() {
        val algo = cromosoma.imprimir()
        val cosa = cromosoma2.imprimir()

        assertEquals(0, individuo.fitness)
        assertEquals(0, individuo2.fitness)
        individuo.defaultFitness()
        individuo2.defaultFitness()
        println("$algo ${individuo.fitness}")
        println("$cosa ${individuo2.fitness}")
    }
}
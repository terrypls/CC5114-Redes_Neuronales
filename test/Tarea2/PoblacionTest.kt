package Tarea2

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PoblacionTest {
    lateinit var alfabeto: String
    lateinit var poblacion: Poblacion
    lateinit var poblacion2: Poblacion
    @BeforeEach
    fun setUp() {
        poblacion = Poblacion(10, 5, .2)
        alfabeto = "abcdefghijklmnopqrstuvwxyz"
    }

    @Test
    fun crearPoblacionChar() {
        poblacion.crearPoblacionChar("bolso", alfabeto)
        assertEquals(10, poblacion.individuo.size)
        poblacion.crearPoblacionChar("bolso", alfabeto)
        poblacion.crearPoblacionChar("bolso", alfabeto)
        assertEquals(10, poblacion.individuo.size)

    }


    private fun aux(palabra: String): Int {
        var contador = 0
        val bolso = "bolso".toCharArray()
        val arreglo = palabra.toCharArray()
        for (i in bolso.indices) {
            if (arreglo[i] == bolso[i])
                contador++
        }

        return contador
    }

    @Test
    fun evolucionar() {
        var c1 = 0
        var c2 = 0
        poblacion.crearPoblacionChar("bolso", alfabeto)
        val ref = poblacion.individuo
        poblacion.evolucionar()
        ref.map {

            assertEquals(aux(it.imprimir()), it.fitness)
            println("bolso\n${it.imprimir()}")
            println("$c1. Fitnes esperada: ${aux(it.imprimir())} Fitness Real:${it.fitness}\n ----------------")
            c1++
        }
        println("despues de mezclar")
        poblacion.individuo.map {
            assertEquals(aux(it.imprimir()), it.fitness)
            println("bolso\n${it.imprimir()}")
            println("$c2 Fitnes esperada: ${aux(it.imprimir())} Fitness Real:${it.fitness}\n ----------------")
            c2++
        }
    }

    @Test
    fun fitness() {

    }
}
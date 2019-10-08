package Tarea2

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AGEncontrarPalabraTest {
    lateinit var algoritmo: AGEncontrarPalabra
    @BeforeEach
    fun setUp() {
        algoritmo = AGEncontrarPalabra(100, 3, 0.2)
    }

    @Test
    fun inicializarPoblacion() {

        algoritmo.inicializarPoblacion(100, 3)
        algoritmo.poblacion.map { println(it) }

    }

    @Test
    fun evaluarPoblacion() {
    }

    @Test
    fun seleccion() {
    }

    @Test
    fun reproduccion() {
    }
}
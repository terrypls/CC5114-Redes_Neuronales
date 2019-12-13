package Tarea3

import Tarea3.Ejercicios.funcionSinLimites
import Tarea3.Nodos.Nodo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BosqueTest {
    lateinit var terminales: MutableList<Int>
    lateinit var funciones: MutableList<(Nodo, Nodo) -> Int>
    lateinit var bosque: Bosque
    lateinit var otroBosque: Bosque
    lateinit var generador: AST
    lateinit var funFitness: (Nodo) -> Double
    @BeforeEach
    fun setUp() {
        terminales = mutableListOf(25, 7, 8, 100, 4, 2)
        funciones = mutableListOf(Suma(), Resta(), Multi())
        generador = AST(funciones, terminales)
        funFitness = funcionSinLimites()
    }

    @Test
    fun crear() {
        bosque = Bosque(funFitness, 7, funciones, terminales, 100, .2)
        val a = mutableListOf<Int>()
        bosque.arboles.map {
            a.add(it.raiz.eval())
        }
        println(a)
    }

    @Test
    fun evolucionar() {
        bosque = Bosque(funFitness, 2, funciones, terminales, 15, .2)
        bosque.evolucionar()
        val a = mutableListOf<Int>()
        bosque.arboles.map {
            a.add(it.raiz.eval())
        }
        println(a)
    }

    @Test
    fun estadisticas() {
    }
}
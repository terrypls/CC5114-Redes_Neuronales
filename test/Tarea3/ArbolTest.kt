package Tarea3

import Tarea3.Arboles.AST
import Tarea3.Arboles.Arbol
import Tarea3.Ejercicios.funcionSinLimites
import Tarea3.Nodos.Nodo
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test

internal class ArbolTest {
    lateinit var terminales: MutableList<Int>
    lateinit var funciones: MutableList<(Nodo, Nodo) -> Int>
    lateinit var arbol: Arbol
    lateinit var otroArbol: Arbol
    lateinit var generador: AST
    lateinit var funFitness: (Nodo) -> Double
    @BeforeEach
    fun setUp() {
        terminales = mutableListOf(25, 7, 8, 100, 4, 2)
        funciones = mutableListOf(Suma(), Resta(), Multi(), Max())
        generador = AST(funciones, terminales)
        funFitness = funcionSinLimites()
    }

    @Test
    fun creacion() {
        arbol = Arbol(generador, funFitness, 8)
        println(arbol.fitness)


    }

    @Test
    fun comparar() {
        arbol = Arbol(generador, funFitness, 8)
        otroArbol = Arbol(generador, funFitness, 8)
        println("${arbol.fitness} ${otroArbol.fitness}")
        println(arbol.compareTo(otroArbol))
    }
}
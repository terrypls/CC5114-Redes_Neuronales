package Tarea3

import Tarea3.Nodos.Nodo
import Tarea3.Nodos.NodoTerminal
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ArbolTest {

    lateinit var Arbol: Arbol
    @BeforeEach
    fun setUp() {
        val dummy = NodoTerminal(1)
        val funcionesActivacion: MutableList<(Nodo, Nodo) -> Int> =
            mutableListOf(Suma(), Resta(dummy, dummy), Multi(dummy, dummy))
        val valores = mutableListOf(1, 3, 4, 5)
        val ast = AST(funcionesActivacion, valores)
        Arbol = Arbol(ast, fun(a: Nodo) = a.eval().toDouble(), 10)

    }

    @Test
    fun creacion() {
        println(Arbol.raiz)
        Arbol.raiz = Arbol.generador.invoke(2)
        val holo: Nodo = Arbol.raiz

        val halo: MutableList<Nodo> = holo.serializar()
        println(halo.first().argumentos)
        println(halo.size)
        println(halo)
        assertTrue(halo.size <= 8)
        val helo = Arbol.generador.invoke(0)
        assertTrue(helo.serializar().size == 1)


    }
}
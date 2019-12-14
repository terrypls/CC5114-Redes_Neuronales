package Tarea3

import Tarea3.Arboles.AST
import Tarea3.Nodos.Nodo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ASTTest {

    lateinit var terminales: MutableList<Int>
    lateinit var funciones: MutableList<(Nodo, Nodo) -> Int>
    lateinit var arbol: AST
    @BeforeEach
    fun setUp() {
        terminales = mutableListOf(25, 7, 8, 100, 4, 2)
        funciones = mutableListOf(Suma(), Resta(), Multi(), Max())
        arbol = AST(funciones, terminales)
    }

    @Test
    fun crearArbol() {
        val prueba = arbol.invoke(5)
        println(prueba.eval())
    }
}
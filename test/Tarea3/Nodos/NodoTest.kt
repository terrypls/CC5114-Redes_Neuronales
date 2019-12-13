package Tarea3.Nodos

import Tarea3.Suma
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NodoTest {

    var dummy = NodoTerminal(0, 0)
    lateinit var primero: Nodo
    lateinit var segundo: Nodo
    lateinit var tercero: Nodo
    lateinit var terminal: NodoTerminal
    lateinit var terminal1: NodoTerminal
    lateinit var terminal7: NodoTerminal
    @BeforeEach
    fun setUp() {

        terminal = NodoTerminal(4, 3)
        terminal1 = NodoTerminal(5, 3)
        terminal7 = NodoTerminal(7, 3)
        primero = Nodo(Suma(), 1)
        segundo = Nodo(Suma(), 1)
        tercero = Nodo(Suma(), 1)


    }

    @Test
    fun eval() {
        primero.argumentos.add(terminal)
        primero.argumentos.add(terminal1)
        assertEquals(9, primero.eval())

        segundo.argumentos.add(tercero)
        segundo.argumentos.add(terminal7)
        tercero.argumentos.add(terminal)
        tercero.argumentos.add(terminal1)
        assertEquals(16, segundo.eval())


    }

    @Test
    fun serializar() {
        primero.argumentos.add(terminal)
        primero.argumentos.add(terminal1)
        segundo.argumentos.add(tercero)
        segundo.argumentos.add(terminal7)
        tercero.argumentos.add(terminal)
        tercero.argumentos.add(terminal1)

        assertEquals(2, primero.argumentos.size)
        val lista = mutableListOf<Nodo>(primero, terminal, terminal1)
        val lista2 = primero.serializar()
        val lista3 = segundo.serializar()
        assertEquals(5, lista3.size)
        assertEquals(3, lista2.size)

    }

    @Test
    fun copiar() {
        primero.argumentos.add(terminal)
        primero.argumentos.add(terminal1)
        val nodo: Nodo = primero.copiar()
        for (i in nodo.argumentos.indices) {
            assertEquals(nodo.argumentos[i].eval(), primero.argumentos[i].eval())
        }
        assertEquals(nodo.operacion, primero.operacion)

        segundo.argumentos.add(tercero)
        segundo.argumentos.add(terminal7)
        tercero.argumentos.add(terminal)
        tercero.argumentos.add(terminal1)

        val nodoaux: Nodo = segundo.copiar()
        val ble = nodoaux.serializar()
        assertEquals(5, ble.size)



    }

    @Test
    fun reemplazar() {
        primero.argumentos.add(terminal)
        primero.argumentos.add(terminal1)
        segundo.argumentos.add(tercero)
        segundo.argumentos.add(terminal7)
        tercero.argumentos.add(terminal)
        tercero.argumentos.add(terminal1)


        assertEquals(3, primero.serializar().size)
        primero.reemplazar(segundo)
        assertEquals(5, primero.serializar().size)

    }


}
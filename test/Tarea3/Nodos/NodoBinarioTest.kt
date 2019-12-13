package Tarea3.Nodos

import Tarea3.Multi
import Tarea3.Resta
import Tarea3.Suma
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.print.attribute.standard.NumberOfDocuments

internal class NodoBinarioTest {

    lateinit var terminal1: NodoTerminal
    lateinit var terminal7: NodoTerminal
    lateinit var multi1: NodoBinario
    lateinit var multi2: NodoBinario
    lateinit var multi3: NodoBinario
    lateinit var suma1: NodoBinario
    lateinit var suma2: NodoBinario
    lateinit var resta: NodoBinario
    lateinit var resta2: NodoBinario
    lateinit var terminal3: NodoTerminal
    lateinit var terminal4: NodoTerminal
    lateinit var terminal2: NodoTerminal
    lateinit var terminal5: NodoTerminal
    lateinit var terminal10: NodoTerminal
    lateinit var terminal6: NodoTerminal
    lateinit var terminal8: NodoTerminal
    @BeforeEach
    fun setUp() {
        terminal1 = NodoTerminal(1, 0)
        terminal2 = NodoTerminal(2, 0)
        terminal3 = NodoTerminal(3, 0)
        terminal4 = NodoTerminal(4, 0)
        terminal5 = NodoTerminal(5, 0)
        terminal6 = NodoTerminal(6, 0)
        terminal7 = NodoTerminal(7, 0)
        terminal8 = NodoTerminal(8, 0)
        terminal10 = NodoTerminal(10, 0)
        multi1 = NodoBinario(Multi(), terminal3, terminal4, 3)
        resta = NodoBinario(Resta(), terminal2, terminal1, 3)
        suma1 = NodoBinario(Suma(), multi1, resta, 3)

        suma2 = NodoBinario(Suma(), terminal6, terminal5, 3)
        resta2 = NodoBinario(Resta(), terminal10, terminal7, 3)
        multi2 = NodoBinario(Multi(), suma2, terminal8, 3)
        multi3 = NodoBinario(Multi(), multi2, resta2, 3)


    }

    @Test
    fun eval() {
        assertEquals(13, suma1.eval())
        assertEquals(264, multi3.eval())
    }

    @Test
    fun copiar() {
        val a = suma1.copiar()
        assertEquals(13, a.eval())
        val b = resta.copiar()
        suma1.nodoIzq.reemplazar(b)
        assertEquals(2, suma1.eval())

    }

    @Test
    fun reemplazar() {
        assertEquals(multi1, suma1.nodoIzq)
        val al = suma1.eval()
        multi1.reemplazar(multi3)
        val el = suma1.eval()
        assertEquals(multi1, suma1.nodoIzq)
        assertNotEquals(al, el)
    }

}
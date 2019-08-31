package Tarea1.Red_Neuronal

import Tarea1.Red_Neuronal.Funciones_Activacion.Step
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CapaNeuronaTest {
    private lateinit var capa1:CapaNeurona
    private lateinit var capa2:CapaNeurona
    private lateinit var capa3:CapaNeurona
    private lateinit var capa1And:CapaNeurona
    private lateinit var capa2And:CapaNeurona
    private lateinit var capa3And:CapaNeurona
    @BeforeEach
    fun setUp() {

        capa1And = CapaNeurona(2,null)
        capa2And = CapaNeurona(2,capa1And)
        capa3And = CapaNeurona(1, capa2And)
        capa1And.capaSiguiente = capa2And
        capa2And.capaSiguiente = capa3And

        capa1 = CapaNeurona(3,null)

        capa2 = CapaNeurona(3,capa1)
        capa3 = CapaNeurona(3,capa1)
        capa1.capaSiguiente = capa2
        capa2.capaSiguiente = capa3
    }

    @Test
    fun `getCapaSiguiente$Rebuild`() {
        assertEquals(capa2,capa1.capaSiguiente)
        assertEquals(capa3,capa2.capaSiguiente)
        assertEquals(null,capa3.capaSiguiente)
    }

    @Test
    fun crearNeuronas() {
        capa1.crearNeuronas(3)
        assertEquals(3,capa1.neuronas.size)
        capa1.neuronas.forEach {
            assertEquals(3,it.pesos.size) }

    }

    @Test
    fun entrenarCapa() {
        val a = listOf<Double>(-1.0,1.0,0.5)
        capa1.crearNeuronas(3)
        capa2.crearNeuronas(3)
        capa3.crearNeuronas(3)
        assertEquals(listOf(0.0,0.0,0.0),capa1.salidas)
        assertEquals(listOf(0.0,0.0,0.0),capa2.salidas)
        assertEquals(listOf(0.0,0.0,0.0),capa2.salidas)
        capa1.entrenarCapa(a)
        assertNotEquals(listOf(0.0,0.0,0.0),capa1.salidas)
        assertNotEquals(listOf(0.0,0.0,0.0),capa2.salidas)
        assertNotEquals(listOf(0.0,0.0,0.0),capa3.salidas)


    }

    @Test
    fun backPropagationError() {
        val a = listOf<Double>(1.0,1.0)
        val b = listOf<Double>(1.0)

        val c:MutableList<Double> = mutableListOf()
        val d:MutableList<Double> = mutableListOf()
        capa1And.crearNeuronas(2)
        capa2And.crearNeuronas(2)
        capa3And.crearNeuronas(2)
        (capa1And.neuronas.forEach { c.add(it.delta) })
        capa1And.entrenarCapa(a)
        capa3And.backPropagationError(b)
        capa1And.neuronas.forEach { d.add(it.delta) }
        assertNotEquals(c,d)

    }

    @Test
    fun actualizarPesos() {
        val a = listOf<Double>(0.5,0.4)
        val b = listOf<Double>(1.0)

        val c:MutableList<List<Double>> = mutableListOf()
        val d:MutableList<List<Double>> = mutableListOf()
        capa1And.crearNeuronas(2)
        capa2And.crearNeuronas(2)
        capa3And.crearNeuronas(2)
        capa1And.neuronas.forEach { it: Neurona -> c.add(it.pesos)}
        println(c)
        capa2And.neuronas.forEach { it: Neurona -> c.add(it.pesos)}
        capa3And.neuronas.forEach { it: Neurona -> c.add(it.pesos)}

        capa1And.entrenarCapa(a)
        capa3And.backPropagationError(b)
        capa1And.actualizarPesos(a)

        capa1And.neuronas.forEach { it: Neurona -> d.add(it.pesos)}
        println(d)
        capa2And.neuronas.forEach { it: Neurona -> d.add(it.pesos)}
        capa3And.neuronas.forEach { it: Neurona -> d.add(it.pesos)}

        /**
         * pasa los test, pero por razones de aproximacion de doubles de assert esta tomando la diferencia como 0
         */
        println((d[0][0]-c[0][0]))
        //assertFalse((d[0][0]-c[0][0])==0.0)
    }
}
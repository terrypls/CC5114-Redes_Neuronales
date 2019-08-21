package Tarea1.Neurona_Sigmoid

import Extras.Recta
import Tarea1.AbstractNeuronTest
import Tarea1.Ejercicios.RectaPerceptron

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SigmoidNeuronTest : AbstractNeuronTest() {
    private val trainPoints = 1000
    private val recta: Recta = Recta(1, 0)
    private val trainSet = utils.crearPuntos(trainPoints, 20, 20, recta)
    private lateinit var perceptron: RectaPerceptron
    private var exitos = 0
    val entradas:Pair<List<Int>,List<Int>> = Pair(listOf(1,1,0,0), listOf(1,0,1,0))
    val and:Pair<Pair<List<Int>,List<Int>>,List<Int>> = Pair(entradas, listOf(1,0,0,0))
    val or:Pair<Pair<List<Int>,List<Int>>,List<Int>> = Pair(entradas, listOf(1,1,1,0))
    val nand:Pair<Pair<List<Int>,List<Int>>,List<Int>> = Pair(entradas, listOf(0,1,1,1))

@Test
fun sigmoiddAnd(){



    assertEquals(1, perceptron.procesador(inputs11),"test 11")
    assertEquals(0, perceptron.procesador(inputs10),"test 10")
    assertEquals(0, perceptron.procesador(inputs01),"test 01")
    assertEquals(0, perceptron.procesador(inputs00),"test 00")
}

    @Test
    fun sinEntrenamiento() {

    }

    @Test
    fun entrenamientoSimple() {
    }

    @Test
    fun multipleEntrenamientos() {
    }
}
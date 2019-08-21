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
    val entrada1: List<Double> = listOf(1.0, 1.0, 0.0, 0.0)
    val entradas2: List<Double> = listOf(1.0, 0.0, 1.0, 0.0)
    private val and: List<Double> = listOf(1.0, 0.0, 0.0, 0.0)
    val or: List<Double> = listOf(1.0, 1.0, 1.0, 0.0)
    val nand: List<Double> = listOf(0.0, 1.0, 1.0, 1.0)


    /**
     * Test basado en codigo de Bastian Inostroza (github: https://github.com/BastyZ/NeuralPerceptron )
     * Para comprobar el funcionamiento de la neurona
     */

    @Test
    fun neuronCurveTest() {
        //test generado por @Bastyz en github
        val neuron = SigmoidNeuron(1)
        neuron.pesos = arrayOf(1.0)
        neuron.bias = 0.0
        neuron.learningRate = 0.0

        var lastValue = 1.0
        for (j in 20 downTo -20 step 2) {
            val i = j.toDouble() / 10
            // testing that is the curve it's supposed to be
            assertTrue(lastValue - neuron.procesador(listOf(i)) <= 0.15)
            assertTrue(neuron.procesador(listOf(i)) > .0)
            lastValue = neuron.procesador(listOf(i))
        }
    }


    @Test
    fun sigmoidAnd() {
        repeat(100) {
            for (i in 3 downTo 0) {
                sigmoidAnd.entrenar(listOf(entrada1[i], entradas2[i]), and[i])
            }
        }

        assertEquals(1, sigmoidAnd.threshold(sigmoidAnd.procesador(listOf(1.0, 1.0)), 0.5), "test 11")
        assertEquals(0, sigmoidAnd.threshold(sigmoidAnd.procesador(listOf(1.0, 0.0)), 0.5), "test 10")
        assertEquals(0, sigmoidAnd.threshold(sigmoidAnd.procesador(listOf(0.0, 1.0)), 0.5), "test 01")
        assertEquals(0, sigmoidAnd.threshold(sigmoidAnd.procesador(listOf(0.0, 0.0)), 0.5), "test 00")
    }

    @Test
    fun sigmoidOr() {
        repeat(100) {
            for (i in 3 downTo 0) {
                sigmoidOr.entrenar(listOf(entrada1[i], entradas2[i]), or[i])
            }
        }

        assertEquals(1, sigmoidOr.threshold(sigmoidOr.procesador(listOf(1.0, 1.0)), 0.5), "test 11")
        assertEquals(1, sigmoidOr.threshold(sigmoidOr.procesador(listOf(1.0, 0.0)), 0.5), "test 10")
        assertEquals(1, sigmoidOr.threshold(sigmoidOr.procesador(listOf(0.0, 1.0)), 0.5), "test 01")
        assertEquals(0, sigmoidOr.threshold(sigmoidOr.procesador(listOf(0.0, 0.0)), 0.5), "test 00")
    }

    @Test
    fun sigmoidNand() {
        repeat(100) {
            for (i in 3 downTo 0) {
                sigmoidNand.entrenar(listOf(entrada1[i], entradas2[i]), nand[i])
            }
        }

        assertEquals(0, sigmoidNand.threshold(sigmoidNand.procesador(listOf(1.0, 1.0)), 0.5), "test 11")
        assertEquals(1, sigmoidNand.threshold(sigmoidNand.procesador(listOf(1.0, 0.0)), 0.5), "test 10")
        assertEquals(1, sigmoidNand.threshold(sigmoidNand.procesador(listOf(0.0, 1.0)), 0.5), "test 01")
        assertEquals(1, sigmoidNand.threshold(sigmoidNand.procesador(listOf(0.0, 0.0)), 0.5), "test 00")
    }

}
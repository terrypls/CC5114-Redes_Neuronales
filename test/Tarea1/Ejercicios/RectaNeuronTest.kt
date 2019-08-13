package Tarea1.Ejercicios

import Extras.recta
import Tarea1.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RectaNeuronTest : AbstractNeuronTest() {


    protected val trainPoints = 1000
    protected val testPoints = 10000
    val recta: recta = recta(1, 2, -1, 4)
    protected val trainSet = utils.crearPuntos(trainPoints, 10, 10, recta)
    protected val testSet = utils.crearPuntos(testPoints,10,10,recta)

    @Test
    fun trainOnce() {
        val neuron = RectaPerceptron(initPesos, initBias)
        trainSet.forEach {
            neuron.entrenar(it.first, it.second)
        }
        // We change the set of points to test
        var successfulTries = 0
        testSet.forEach {
            when {
                neuron.procesador(it.first) == it.second -> successfulTries++
            }
        }
        val successRate: Double = successfulTries.toDouble() / testPoints.toDouble()
        print("One train : success rate: $successRate \n")
        // We want it to be better than random
        assertTrue(successRate > 0.5)
    }
    }

package Tarea1.Ejercicios

import Extras.Recta
import Tarea1.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RectaNeuronTest : AbstractNeuronTest() {


    private val trainPoints = 1000
    private val testPoints = 100000
    private val recta: Recta = Recta(-1, 4)
    private val trainSet = utils.crearPuntos(trainPoints, 15, 15, recta)
    private val testSet = utils.crearPuntos(testPoints, 15, 15, recta)
    private lateinit var perceptron: RectaPerceptron
    private var exitos = 0

    @BeforeEach
    fun perceptro() {
        perceptron = RectaPerceptron(initPesos, initBias)
        exitos = 0
    }

    @Test
    fun sinEntrenamiento() {
        testSet.forEach {
            when {
                perceptron.procesador(it.first) == it.second -> exitos++
            }
        }

        val successRate: Double = exitos / testPoints.toDouble()
        print("Simple : success rate: $successRate \n")
        assertTrue(successRate > 0.25)

    }

    @Test
    fun entrenamientoSimple() {

        trainSet.forEach {
            perceptron.entrenar(it.first, it.second)
        }

        testSet.forEach {
            when {
                perceptron.procesador(it.first) == it.second -> exitos++
            }
        }

        val successRate: Double = exitos / testPoints.toDouble()
        print("Simple : success rate: $successRate \n")
        assertTrue(successRate > 0.5)
    }

    @Test
    fun entrenamientoMultiple() {


    }


}

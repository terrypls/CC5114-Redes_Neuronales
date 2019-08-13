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
        assertTrue(successRate > 0.0)
    }

    @Test
    fun entrenamientoSimple() {
        var holi: MutableList<Pair<Double, Double>> = mutableListOf(Pair(perceptron.pesos[0], perceptron.pesos[1]))
        println("pre")
        trainSet.forEach {
            perceptron.entrenar(it.first, it.second)
            holi.add(Pair(perceptron.pesos[0], perceptron.pesos[1]))
        }
        holi.map { println("Pesos $it ") }



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

        repeat(100) {
            trainSet.forEach {
                perceptron.entrenar(it.first, it.second)

            }

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
}

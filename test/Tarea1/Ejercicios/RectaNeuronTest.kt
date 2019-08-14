package Tarea1.Ejercicios

import Extras.Recta
import Tarea1.*
import Tarea1.Perceptron.RectaNeurona

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RectaNeuronTest : AbstractNeuronTest() {


    private val trainPoints = 10
    private val testPoints = 100000
    private val recta: Recta = Recta(1, 0)
    private val trainSet = utils.crearPuntos(trainPoints, 20, 20, recta)
    private val testSet = utils.crearPuntos(testPoints, 20, 20, recta)
    private lateinit var perceptron: RectaNeurona
    private var exitos = 0

    @BeforeEach
    fun perceptro() {
        //perceptron = RectaPerceptron(initPesos, initBias)
        perceptron= RectaNeurona(arrayOf(0.0, 0.0), 0.0)
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
        print("Sin entrenamiento : exito: $successRate \n")
        assertTrue(successRate > 0.5)
    }

    @Test
    fun entrenamientoSimple() {
        val holi: MutableList<Pair<Double, Double>> = mutableListOf(Pair(perceptron.pesos[0], perceptron.pesos[1]))
        trainSet.forEach {
            perceptron.entrenar(it.first, it.second)
            holi.add(Pair(perceptron.pesos[0], perceptron.pesos[1]))
        }

        testSet.forEach {
            when {
                perceptron.procesador(it.first) == it.second -> exitos++
            }
        }
        val successRate: Double = exitos / testPoints.toDouble()
        print("Un entrenamiento : exito: $successRate \n")
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
        print("Multiple : exito: $successRate \n")
        assertTrue(successRate > 0.5)
    }
}

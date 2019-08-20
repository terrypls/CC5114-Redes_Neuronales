package Tarea1.Ejercicios

import Extras.Recta
import Tarea1.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.knowm.xchart.QuickChart
import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.XYChartBuilder
import org.knowm.xchart.XYSeries
import java.lang.Thread.sleep
import kotlin.random.Random
import javax.swing.Spring.width
import javax.swing.Spring.height


internal class RectaNeuronTest : AbstractNeuronTest() {


    private val trainPoints = 1000
    private val recta: Recta = Recta(1, 0)
    private val trainSet = utils.crearPuntos(trainPoints, 20, 20, recta)
    private lateinit var perceptron: RectaPerceptron
    private var exitos = 0

    @BeforeEach
    fun perceptro() {
        perceptron = RectaPerceptron(initPesos, initBias)
        //perceptron = RectaPerceptron(arrayOf(-1.0, -1.0), -1.0)
        exitos = 0
    }

    @Test
    fun sinEntrenamiento() {
        val posX: MutableList<Int> = mutableListOf()
        val posY: MutableList<Int> = mutableListOf()
        val posX1: MutableList<Int> = mutableListOf()
        val posY1: MutableList<Int> = mutableListOf()
        val ejeX = (-20..20).toList()
        val ejeY = (-20..20).toList()
        trainSet.forEach {
            if (perceptron.procesador(it.first) == it.second) {
                posX.add(it.first[0])
                posY.add(it.first[1])
            }else{
                posX1.add(it.first[0])
                posY1.add(it.first[1])
            }
            when {
                perceptron.procesador(it.first) == it.second -> exitos++

            }
        }
        val successRate: Double = exitos / trainPoints.toDouble()
        print("Sin entrenamiento : exito: $successRate \n")
        // Create Chart
        val chart = XYChartBuilder().width(600).height(400).title("Area Chart").xAxisTitle("X").yAxisTitle("Y").build()
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.addSeries("posiciones positivas", posX, posY)
        chart.addSeries("posiciones negativas",posX1,posY1)
        chart.addSeries("recta",ejeX,ejeY)
        SwingWrapper(chart).displayChart()
        sleep(5000)

    }

    @Test
    fun entrenamientoSimple() {
        val posX: MutableList<Int> = mutableListOf()
        val posY: MutableList<Int> = mutableListOf()
        val posX1: MutableList<Int> = mutableListOf()
        val posY1: MutableList<Int> = mutableListOf()
        val ejeX = (-20..20).toList()
        val ejeY = (-20..20).toList()

        trainSet.forEach {
            perceptron.entrenar(it.first, it.second)
        }
        val chao: MutableList<Pair<Int, Int>> = mutableListOf(Pair(-99, -99))
        trainSet.forEach {
            if (perceptron.procesador(it.first) ==1 ) {
                posX.add(it.first[0])
                posY.add(it.first[1])
            }else{
                posX1.add(it.first[0])
                posY1.add(it.first[1])
            }
            chao.add(Pair(perceptron.procesador(it.first), it.second))
            when {
                perceptron.procesador(it.first) == it.second -> exitos++
            }
        }
        chao.removeAt(0)
        val successRate: Double = exitos / trainPoints.toDouble()
        print("Un entrenamiento : exito: $successRate \n")
        val chart = XYChartBuilder().width(600).height(400).title("Area Chart").xAxisTitle("X").yAxisTitle("Y").build()
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.addSeries("posiciones positivas", posX, posY)
        chart.addSeries("posiciones negativas",posX1,posY1)
        chart.addSeries("recta",ejeX,ejeY)
        SwingWrapper(chart).displayChart()
        sleep(5000)
    }

    @Test
    fun entrenamientoMultiple() {
        val succeso = mutableListOf<Double>()

        repeat(15) {
            val subset = mutableListOf<Pair<List<Int>, Int>>()
            val otroSubset = mutableListOf<Pair<List<Int>, Int>>()
            repeat(30) {
                subset.add(trainSet.get(Random.nextInt(0, 99)))


            }
            repeat(20) {
                otroSubset.add(trainSet.get(Random.nextInt(0, 99)))
            }

            exitos = 0
            subset.forEach {
                perceptron.entrenar(it.first, it.second)
            }
            val chao: MutableList<Pair<Int, Int>> = mutableListOf()
            otroSubset.forEach {
                chao.add(Pair(perceptron.procesador(it.first), it.second))
                when {
                    perceptron.procesador(it.first) == it.second -> exitos++
                }
            }

            succeso.add((exitos / 20).toDouble())


        }
        print(succeso)
        val eje = (1..15).toList()

        val chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", eje, succeso)

        // Show it
        SwingWrapper(chart).displayChart()
        sleep(5000)


    }
}

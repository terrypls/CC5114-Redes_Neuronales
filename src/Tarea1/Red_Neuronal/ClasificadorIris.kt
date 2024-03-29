package Tarea1.Red_Neuronal

import Extras.Graficador
import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import kotlin.system.exitProcess

/**
 * @autor Sebastian Donoso
 */

/**
 * clasificador para clasificar 3 tipos de platas segun informacion de su iris
 * dataset para entrenar y probar la red fue sacada de la siguiente direccion:
 *  https://archive.ics.uci.edu/ml/datasets/Iris
 *  @param nombreArchivo archivo que se abrira
 *  @param numEntrenamientos cantidad de veces que se entrenara la red
 */

class ClasificadorIris(val nombreArchivo: String, val numEntrenamientos: Int) {
    private val plot = Graficador("Learning Rate", "Entrenamientos", "Precision (%)")
    private val plot2 = Graficador("Resultados de Test", "Iteraciones", "Precision(%)")
    private val plot3 = Graficador("Error", "Entrenamientos", "Valor")
    private var sepalLength: MutableList<Double> = mutableListOf()
    private var sepalWidth: MutableList<Double> = mutableListOf()
    private var petalLength: MutableList<Double> = mutableListOf()
    private var petalWidth: MutableList<Double> = mutableListOf()
    private var flower: MutableList<String> = mutableListOf()
    private var hotFlower: MutableList<List<Double>> = mutableListOf()
    private var pares: MutableList<Pair<List<Double>, List<Double>>> = mutableListOf()
    private var redNeuronal: RedNeuronal
    private var entrenar: Int = 0
    private var testing: Int = 0

    var cantNeuronas = listOf(4, 3, 4, 3)

    init {
        redNeuronal = RedNeuronal(4, cantNeuronas, 4, 3)
        procesarDatos()
    }

    /**
     * metodo para procesar los datos del archivo provisto y dejarlos
     * usables para la red neuronal
     */
    private fun procesarDatos() {
        var reader: BufferedReader? = null
        try {
            reader = File(nombreArchivo).bufferedReader()
            val lines = mutableListOf<String>()
            reader.useLines { line -> line.forEach { lines.add(it) } }

            val largo = lines.size
            lines.removeAt(largo - 1)
            for (line in lines) {
                val aux = line.split(",")
                sepalLength.add(aux[0].toDouble())
                sepalWidth.add(aux[1].toDouble())
                petalLength.add(aux[2].toDouble())
                petalWidth.add(aux[3].toDouble())
                flower.add(aux[4])
            }
        } catch (e: FileNotFoundException) {
            print("File not found.")
        } finally {
            if (reader != null) reader.close()
            else exitProcess(-1)
        }
        normalizar(sepalLength)
        normalizar(sepalWidth)
        normalizar(petalLength)
        normalizar(petalWidth)
        hotEncoding()

        entrenar = (hotFlower.size * 0.8).toInt()


        for (i in hotFlower.indices) {
            pares.add(Pair(listOf(sepalLength[i], sepalWidth[i], petalLength[i], petalWidth[i]), hotFlower[i]))
        }
        pares.shuffle()
        for (i in 0 until entrenar) {

            redNeuronal.agregarSet(pares[i].first, pares[i].second)
        }
        for (i in (entrenar + 1) until hotFlower.size - 1)
            redNeuronal.agregarTest(pares[i].first, pares[i].second)

        redNeuronal.entrenarRed(numEntrenamientos)
    }

    /**
     * metodo que realiza pruebas sobre la red entrenada con los datos restantes del data set y lo grafica
     * En particular realiza un decimo de iteraciones respecto a el entrenamiento
     */
    fun pruebas() {
        redNeuronal.probarRed(numEntrenamientos / 10)
        graficarTest()
    }


    /**
     * metodo para realizar la normalizacion de los datos a el rango [0,1] de una lista
     * @param lista conjunto de datos a normalizar
     */
    private fun normalizar(lista: MutableList<Double>) {
        val min: Double = lista.min()!!
        val max: Double = lista.max()!!
        for (i in lista.indices) {
            lista[i] = redNeuronal.normalizar(lista[i], min, max)
        }
    }

    /**
     * metodo para realizar hot-enconding sobre los resultados esperados del dataset
     */
    private fun hotEncoding() {
        for (i in flower.indices) {
            when {
                flower[i] == "Iris-setosa" -> hotFlower.add(listOf(1.0, .0, .0))
                flower[i] == "Iris-versicolor" -> hotFlower.add(listOf(.0, 1.0, .0))
                flower[i] == "Iris-virginica" -> hotFlower.add(listOf(.0, .0, 1.0))
            }
        }
    }

    /**
     * metodo para graficar los resultados de precision y error del entrenamiento de la red
     */
    fun graficar() {
        plot.yData = redNeuronal.precision.toDoubleArray()
        plot3.yData = redNeuronal.calculoErro.toDoubleArray()
        plot.draw()
        plot3.draw()
    }

    /**
     * metodo para graficar el resultado de los test realizados
     */
    fun graficarTest() {
        plot2.yData = redNeuronal.pruebaPrecision.toDoubleArray()

        plot2.draw()
    }
}

fun main() {

    val clasificador = ClasificadorIris("Tarea1/DataSet/iris.data", 1000)
    clasificador.graficar()
    clasificador.pruebas()
}
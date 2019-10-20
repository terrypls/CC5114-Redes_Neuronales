package Tarea2

import Extras.Graficador
import Tarea2.Cromosoma.CharCromosoma
import java.lang.StringBuilder
import kotlin.random.Random

/**
 * @author Sebastián Donoso
 */

/**
 * clase que servira como base para la creacion de programas que usen algoritmos geneticos para la busqueda u optimizacion
 * de problemas que se evaluaran durante la realizacion del curso
 */
class AGEncontrarPalabra(

) {

    var vuelta: Int = 0
    var estadisticas: MutableList<Array<Double>> = mutableListOf()
    private val plot = Graficador("Historia", "Generaciones", "Fitness")
    private val plot2 = Graficador("Historia", "Generaciones", "Fitness")
    private val plot3 = Graficador("Historia", "Generaciones", "Fitness")

    fun encontrarPalabra(alfabeto: String, objetivo: String, largoCromosoma: Int, cantPoblacion: Int) {
        vuelta = 0
        val poblacion = Poblacion(cantPoblacion, largoCromosoma, .1)
        poblacion.crearPoblacionChar(objetivo, alfabeto)
        var valores = poblacion.fitness()
        while (valores.second != largoCromosoma) {
            //println("Iteracion: $vuelta Menor: ${valores.first} Mayor: ${valores.second} Palabra: ${poblacion.best}")
            poblacion.evolucionar()
            valores = poblacion.fitness()
            vuelta++
        }
        estadisticas = poblacion.estadisticas
        println("Iteracion $vuelta Menor: ${valores.first} Mayor: ${valores.second} Palabra: ${poblacion.best}")
    }

    /**
     * metodo para graficar los resultados de precision y error del entrenamiento de la red
     */

    fun dibujar(
        menor: MutableList<Double>,
        mayor: MutableList<Double>,
        promedio: MutableList<Double>

    ) {
        plot.minData = menor.toDoubleArray()
        plot.maxData = mayor.toDoubleArray()
        plot.meanData = promedio.toDoubleArray()
        val listaa: MutableList<Double> = mutableListOf()
        for (i in 0 until menor.size) {
            listaa.add(i.toDouble())
        }
        plot.xData = listaa.toDoubleArray()
        plot.yData = menor.toDoubleArray()
        plot.drawMultiple()
    }


}

fun main() {
    val minimo: MutableList<Double> = mutableListOf()
    val maximo: MutableList<Double> = mutableListOf()
    val promedio: MutableList<Double> = mutableListOf()


    val alfabeto: String = "abcdefghijklmnopqrstuvwxyz"
    val binario: String = "10"
    val objetivo = "anitalavalatina"
    val objetivoBinario = "1000101001010101010101111100011100001010101010000110101"
    val poblacion = 10


    val experimento = AGEncontrarPalabra()
    var encontrarPalabra = experimento.encontrarPalabra(alfabeto, objetivo, objetivo.length, poblacion)
    //var encontrarBinario = experimento.encontrarPalabra(binario, objetivoBinario, objetivoBinario.length, poblacion)

    experimento.estadisticas.map {
        minimo.add(it[0])
        maximo.add(it[1])
        promedio.add(it[2])
    }

    experimento.dibujar(minimo, maximo, promedio)
}
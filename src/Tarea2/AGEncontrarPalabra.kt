package Tarea2

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
    fun encontrarPalabra(alfabeto: String, objetivo: String, largoCromosoma: Int, cantPoblacion: Int) {
        var iteracion = 0
        val poblacion = Poblacion(cantPoblacion, largoCromosoma, .1)
        poblacion.crearPoblacionChar(objetivo, alfabeto)

        var valores = poblacion.fitness()
        while (poblacion.fitness().second != largoCromosoma) {
            println("Iteracion: $iteracion Menor: ${valores.first} Mayor: ${valores.second} Palabra: ${poblacion.best}")
            poblacion.evolucionar()
            valores = poblacion.fitness()
            iteracion++
        }
        println("Iteracion $iteracion Menor: ${valores.first} Mayor: ${valores.second} Palabra: ${poblacion.best}")
    }


}

fun main() {
    val alfabeto: String = "abcdefghijklmnopqrstuvwxyz"
    val binario: String = "10"
    val objetivo = "1000101001010101010101111100011100001010101010000110101"
    var yo = AGEncontrarPalabra().encontrarPalabra(binario, objetivo, objetivo.length, 10)
}
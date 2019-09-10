package Tarea2

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
    cantPoblacion: Int,
    cantGenes: Int,
    mutacion: Double
) : IAlgoritmoGenetico {
    lateinit var poblacion: Array<String>
    val abecedario: String = "abcdefghijklmnopqrstuvwxyz"

    init {
        poblacion = Array(cantPoblacion) { "" }
    }

    override fun inicializarPoblacion(cantPoblacion: Int, cantGenes: Int) {
        for (i in 0 until cantPoblacion) {
            poblacion[i] = crearIndividuo(cantGenes)
        }
    }

    private fun crearIndividuo(cantGenes: Int): String {
        val individuo = StringBuilder()

        for (i in 0 until cantGenes) {
            individuo.append(abecedario[Random.nextInt(0, abecedario.length - 1)])
        }
        return individuo.toString()
    }

    override fun evaluarPoblacion() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun evaluarPoblacion(palabra: String) {
        evaluarPoblacion()
    }

    override fun seleccion() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reproduccion() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
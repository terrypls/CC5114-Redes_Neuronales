package Tarea3

import Tarea3.Nodos.Nodo
import kotlin.math.max

/**
 * clase simil a la poblacion de la tarea 2, se encarga del set de individuos(arboles) del algoritmo
 *
 */
class Bosque(
    var funcionFitness: (Nodo) -> Double,
    val profundidad: Int,
    val operaciones: MutableList<(Nodo, Nodo) -> Int>,
    val valoresTerminal: MutableList<Int>,
    val cantArboles: Int,
    val probMutacion: Double
) {
    var historial: MutableList<Array<Double>> = mutableListOf()
    private var generador: AST = AST(operaciones, valoresTerminal) //generador de arboles
    private var arboles: MutableList<Arbol> = mutableListOf()//donde se guardan referencias a los arboles del bosque

    init {
        for (i in 0 until cantArboles) {
            val arbol = Arbol(generador, funcionFitness, profundidad)
            arbol.actualizarFitnesss()
            arboles.add(arbol)
        }
    }

    /**
     * metodo para crear una nueva generacion de arboles para el bosque
     */
    fun evolucionar() {
        val hijos: MutableList<Arbol> = mutableListOf()
        while (hijos.size < arboles.size) {
            val papa = competenciaArboles(arboles.random(), arboles.random())
            val mama = competenciaArboles(arboles.random(), arboles.random())
            val hijo1 = papa.crossover(mama)
            val hijo2 = mama.crossover(papa)

            hijo1.mutar(probMutacion)
            hijo2.mutar(probMutacion)
            hijos.add(hijo1)
            hijos.add(hijo2)
        }
        arboles = hijos
        arboles.map { it.actualizarFitnesss() }
    }

    /**
     * metodo para elegir arbol con mejor fitness entre dos opciones, si tienen igual fitness devuelve al azar
     * @param a un arbol
     * @param b un arbol
     * @return arbol ganador
     */
    fun competenciaArboles(a: Arbol, b: Arbol): Arbol {
        return when (a.compareTo(b)) {
            1 -> a
            -1 -> b
            else -> listOf(a, b).random()

        }
    }

    fun estadisticas(): Pair<Double, Double> {
        var minimo: Double = Double.MAX_VALUE
        var maximo: Double = Double.MIN_VALUE
        var promedio: Double = 0.0
        arboles.map {
            promedio += it.fitness
            if (maximo < it.fitness) {
                maximo = it.fitness

            }
            if (minimo > it.fitness) {
                minimo = it.fitness
            }
        }
        historial.add(arrayOf(minimo.toDouble(), maximo.toDouble(), promedio.toDouble() / cantArboles))
        return Pair(minimo, maximo)
    }
}
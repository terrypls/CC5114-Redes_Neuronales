package Tarea3

import Tarea3.Arboles.AST
import Tarea3.Arboles.Arbol
import Tarea3.Nodos.Nodo
import kotlin.math.max
import kotlin.random.Random.Default.nextInt

/**
 * clase simil a la poblacion de la tarea 2, se encarga del set de individuos(arboles) del algoritmo
 * @param funcionFitness funcion que definira que tan certero es la evaluacion del arbol en relacion al problema
 * @param profundidad tamaño maximo del arbol
 * @param operaciones lista con las operacion que tendran los nodos internos del arbol
 * @param valoresTerminal lista con los valores que tomaran los nodos terminales del arbol
 * @param cantArboles numero de arboles que tendra el bosque
 * @param probMutacion probabilidad de que un nodo de algun arbol mute
 */
class Bosque(
    var funcionFitness: (Nodo) -> Double,
    val profundidad: Int,
    val operaciones: MutableList<(Nodo, Nodo) -> Int>,
    val valoresTerminal: MutableList<Int>,
    val cantArboles: Int,
    val probMutacion: Double
) {
    var maxFitness: Double = Double.MAX_VALUE
    var peorFitness: Double = Double.MIN_VALUE
    var promedio: Double = 0.0
    var historial: MutableList<Array<Double>> = mutableListOf()
    private var generador: AST =
        AST(operaciones, valoresTerminal) //generador de arboles
    var arboles: MutableList<Arbol> = mutableListOf()//donde se guardan referencias a los arboles del bosque

    init {
        for (i in 0 until cantArboles) {
            val arbol = Arbol(generador, funcionFitness, profundidad)
            arboles.add(arbol)
        }
        arboles.sort()
    }

    /**
     * metodo para crear una nueva generacion de arboles para el bosque
     */
    fun evolucionar() {
        val hijos: MutableList<Arbol> = mutableListOf()
        val supervivientes: Int = arboles.size / 3
        var indice = 0
        while (hijos.size < arboles.size) {
            when {
                indice < arboles.size - supervivientes - 1 -> {
                    val papa = competenciaArboles()
                    val mama = competenciaArboles()

                    val hijo1 = papa.crossover(mama)
                    val hijo2 = mama.crossover(papa)

                    hijo1.mutar(probMutacion)
                    hijo2.mutar(probMutacion)
                    hijos.add(hijo1)
                    hijos.add(hijo2)
                }
                else -> hijos.add(arboles[indice++])
            }
        }
        arboles = hijos
        arboles.sort()
    }

    /**
     * ordena los arboles comparando sus fitness, el ultimo es el que tiene el mejor fitness
     */
    fun mejorArbol() = arboles.last()

    /**
     * entrega el fitness del arbol
     */
    fun mejorFitness() = mejorArbol().fitness

    /**
     * metodo para elegir arbol con mejor fitness entre dos opciones, si tienen igual fitness devuelve al azar
     * @param a un arbol
     * @param b un arbol
     * @return arbol ganador
     */
    fun competenciaArboles(): Arbol {
        return arboles[maxOf(nextInt(arboles.size), nextInt(arboles.size))]
    }


}
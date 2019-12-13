package Tarea3

import Tarea3.Nodos.Nodo
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

/**
 * clase simil a individuo de la tarea 2, encargada de manejar las operaciones sobre los arboles
 * @param generador funcion generadora de arboles(cromosomas)
 * @param funcionFitness funcion que calculara que tan correcta es el arbol
 * @param profundidad maxima profundidad que puede tener el arbol
 * @param nodoRaiz raiz de un arbol, puede ser nulo
 */
class Arbol(
    var generador: AST,
    var funcionFitness: (Nodo) -> Double,
    val profundidad: Int? = 10,
    nodoRaiz: Nodo?
) : Comparable<Arbol> {

    internal var raiz: Nodo = when (nodoRaiz) {
        null -> generador.invoke(profundidad)
        else -> nodoRaiz
    }
    var fitness: Double = Double.MAX_VALUE
    var nodos: MutableList<Nodo> = mutableListOf()
    var evaluacion: Int = 0

    init {
        evaluacion = this.eval()
        nodos = raiz.serializar()
    }

    constructor(
        generador: AST,
        funcionFitness: (Nodo) -> Double,
        profundidad: Int?
    ) : this(generador, funcionFitness, profundidad, nodoRaiz = null)

    /**
     * metodo para realizar el crossover de los arboles
     * @param otroArbol el otro arbol padre para el crossover
     * @return el arbol hijo
     */

    fun crossover(otroArbol: Arbol): Arbol {
        val papa: Nodo = this.raiz.copiar()
        val posicion: Nodo = papa.serializar().random()
        var hijo: Nodo? = null
        do hijo = otroArbol.nodos.random().copiar()
        while (hijo!!.profundidad > posicion.profundidad)
        posicion.reemplazar(hijo)
        return Arbol(generador, funcionFitness, profundidad, papa)

    }

    /**
     * metodo que genera una  mutacion en alguno de los nodos del arbol
     * @param prob probabilidad de generar la mutacion
     */
    fun mutar(prob: Double) {
        if (Random.nextDouble() < prob) {
            val nodoAux: Nodo = nodos.random()
            val arbolaux: Nodo = Arbol(
                generador,
                funcionFitness,
                nextInt(nodoAux.profundidad)
            ).raiz
            nodoAux.reemplazar(arbolaux)
            nodos = this.raiz.serializar()
        }

    }

    fun eval(): Int {
        actualizarFitnesss()
        return raiz.eval()
    }

    fun actualizarFitnesss() {
        fitness = funcionFitness(raiz)
    }

    /**
     * metodo para comparar si 2 arboles evaluan a la misma respuesta( no implica que tengan los mismos nodos)
     */
    override fun compareTo(other: Arbol): Int {
        return when {
            fitness == other.fitness -> 0
            fitness > other.fitness -> 1
            else -> -1
        }
    }

    override fun toString(): String {
        return raiz.toString()
    }
}
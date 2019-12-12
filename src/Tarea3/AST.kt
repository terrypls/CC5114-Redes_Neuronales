package Tarea3

import Tarea3.Nodos.Nodo
import Tarea3.Nodos.NodoBinario
import Tarea3.Nodos.NodoTerminal
import kotlin.random.Random.Default.nextDouble

class AST(
    private val operaciones: MutableList<(Nodo, Nodo) -> Int>,
    private val valoresTerminal: MutableList<Int>,
    private val probTerminal: Double = 0.3
) {
    fun invoke(maxProfundida: Int? = 10): Nodo {
        fun crearArbol(profundidad: Int): Nodo {
            when {
                profundidad > 0 -> {
                    val operando = operaciones.random()
                    val hijos: Array<Nodo> = Array(2) {
                        when (nextDouble() < probTerminal) {
                            true -> crearArbol(0)
                            false -> crearArbol(profundidad - 1)
                        }
                    }
                    return NodoBinario(operando, hijos.first(), hijos.last(), profundidad)
                }
                else -> return NodoTerminal(valor = valoresTerminal.random(), profundo = profundidad)
            }
        }
        return crearArbol(maxProfundida!!)

    }
}
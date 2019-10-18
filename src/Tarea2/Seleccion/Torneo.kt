package Tarea2.Seleccion

import Tarea2.Individuo
import kotlin.random.Random


/**
 * clase para realizar la tecnica del torneo para la seleccion aleatoria de los individuos que seran seleccionados para crossover
 *
 */
class Torneo() {

    /**
     * funcion que dada una cantidad fija de individuos para competir, elige el que tiene mejor fitness
     */
    fun competir(individuos: MutableList<Individuo>, cantJugadores: Int): Individuo? {
        var mejor: Individuo? = null
        for (i in 0 until cantJugadores) {
            val jugador = individuos[Random.nextInt(0, individuos.size)]
            if (mejor == null || jugador.fitness > mejor.fitness) {
                mejor = jugador
            }
        }
        return mejor
    }
}
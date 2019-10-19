package Tarea2

import Tarea2.Cromosoma.CharCromosoma
import Tarea2.Cromosoma.MochilaCromosoma
import Tarea2.Seleccion.Torneo
import kotlin.random.Random

class Poblacion(
    var cantPoblacion: Int,
    var largoCromosoma: Int,
    var probMutacion: Double
) {

    var mejor = 0
    var peor = largoCromosoma + 10
    var best = ""
    private var torneo: Torneo = Torneo()
    var individuo: MutableList<Individuo> = mutableListOf()


    /**
     * funcion creadora de poblaciones de CharCromosomas
     */
    fun crearPoblacionChar(objetivo: String, alfabeto: String) {
        individuo = mutableListOf()
        while (individuo.size < cantPoblacion) {
            val aux = Individuo(CharCromosoma(largoCromosoma, alfabeto, objetivo, null), probMutacion)
            aux.defaultFitness()
            individuo.add(aux)
        }
    }

    fun crearPoblacionMochila(objetivo: Int, pesoMaximo: Int, opciones: Array<Pair<Int, Int>>) {
        individuo = mutableListOf()
        while (individuo.size < cantPoblacion) {
            val aux = Individuo(
                MochilaCromosoma(largoCromosoma, opciones, objetivo, pesoMaximo, null),
                probMutacion
            )
            aux.defaultFitness()
            individuo.add(aux)
        }
    }

    /**
     * funcion para realizar la evolucion de los individuos de la poblacion
     */
    fun evolucionar() {
        val hijos: MutableList<Individuo> = mutableListOf()
        while (hijos.size < individuo.size) {
            val papa = torneo.competir(individuo, 5)
            val mama = torneo.competir(individuo, 5)
            val corte = Random.nextInt(0, largoCromosoma)
            val hijo1 = papa!!.crossover(mama!!, corte)
            hijo1.mutar()

            hijos.add(hijo1)
            val hijo2 = mama.crossover(papa, corte)
            hijo2.mutar()

            hijos.add(hijo2)
        }
        individuo = hijos
        individuo.map { it.defaultFitness() }
    }

    /**
     * funcion que obteniene el mejor y peor fitness de la lista de hijos
     */
    fun fitness(): Pair<Int, Int> {

        mejor = 0
        peor = largoCromosoma + 5

        individuo.map {
            if (mejor < it.fitness) {
                mejor = it.fitness
                best = it.imprimir()
            }
            if (peor > it.fitness) {
                peor = it.fitness
            }
        }

        return Pair(peor, mejor)
    }

}
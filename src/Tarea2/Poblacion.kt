package Tarea2

import Tarea2.Cromosoma.CharCromosoma
import Tarea2.Cromosoma.ICromosoma
import Tarea2.Seleccion.Torneo
import kotlin.random.Random

class Poblacion(
    var cantPoblacion: Int,
    var largoCromosoma: Int,
    var probMutacion: Double
) {

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
            aux.charFitness()
            individuo.add(aux)
        }
    }

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

        individuo.map { it.charFitness() }

    }

    fun fitness(): Pair<Int, Int> {

        var mejor = 0
        var peor = largoCromosoma + 5

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
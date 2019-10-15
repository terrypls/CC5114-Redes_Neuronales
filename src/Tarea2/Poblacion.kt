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

    private var torneo: Torneo = Torneo()
    private var individuo: Array<Individuo> = emptyArray()
    private var alfabeto = "abcdefghijklmnopqrstuvwxyz"

    /**
     * funcion creadora de poblaciones de CharCromosomas
     */
    fun crearPoblacionChar(objetivo: String) {
        this.individuo = Array(cantPoblacion) {
            Individuo(
                CharCromosoma(largoCromosoma, alfabeto, objetivo, null),
                probMutacion
            )
        }
    }

    fun evolucionar() {
        var hijo: MutableList<Individuo> = mutableListOf()
        while (hijo.size < individuo.size) {
            var papa = torneo.competir(individuo, 5)
            var mama = torneo.competir(individuo, 5)
            var corte = Random.nextInt()

        }
    }

}
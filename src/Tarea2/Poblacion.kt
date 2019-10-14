package Tarea2

import Tarea2.Cromosoma.CharCromosoma
import Tarea2.Cromosoma.ICromosoma

class Poblacion(
    var cantPoblacion: Int,
    var largoCromosoma: Int,
    var probMutacion: Double
) {

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

}
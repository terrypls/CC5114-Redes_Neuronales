package Tarea2

import Tarea2.Cromosoma.CharCromosoma
import Tarea2.Cromosoma.ICromosoma

/**
 * clase que representara a cada individuo de la poblacion para el algoritmo
 */
class Individuo(
    private var cromosoma: ICromosoma<*>,
    var mutacion: Double
) {
    var cantGenes: Int = cromosoma.genes.size
    var genesPropios = Array(cantGenes) { i -> cromosoma.genes[i] }
    /**
     * funcion que tomara los genes de otro individuo y los combinara con el actual para generar
     * variabilidad genetica a partir del gen dado
     * @param otroIndividuo el individuo con el que se hara el crossover
     * @param posicion posicion desde la cual se cambiara la informacion
     */
    fun crossover(otroIndividuo: Individuo, posicion: Int) {
        assert(posicion <= cantGenes) { "la posicion pedida no existe" }
        assert(this.cantGenes == otroIndividuo.cantGenes) { "no tienen el mismo tamaño" }

    }

    fun mutar() {

    }

    fun charFitness() {

    }


}
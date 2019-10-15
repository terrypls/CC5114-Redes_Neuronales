package Tarea2

import Tarea2.Cromosoma.ICromosoma
import Tarea2.Genes.IGen

/**
 * clase que representara a cada individuo de la poblacion para el algoritmo
 */
class Individuo(
    private var cromosoma: ICromosoma<*>,
    var mutacion: Double
) {
    var cantGenes: Int = cromosoma.genes.size
    var genesPropios = Array(cantGenes) { i -> cromosoma.genes[i] }
    var fitness: Int = 0
    /**
     * funcion que tomara los genes de otro individuo y los combinara con el actual para generar
     * variabilidad genetica a partir del gen dado
     * @param otroIndividuo el individuo con el que se hara el crossover
     * @param posicion posicion desde la cual se cambiara la informacion
     */
    fun crossover(otroIndividuo: Individuo, posicion: Int): Individuo {
        assert(posicion <= cantGenes) { "la posicion pedida no existe" }
        assert(this.cantGenes == otroIndividuo.cantGenes) { "no tienen el mismo tamaño" }
        val nuevoCromosoma = auxCrossover(otroIndividuo.genesPropios, posicion)
        return Individuo(nuevoCromosoma, mutacion)
    }

    private fun auxCrossover(otroIndividuo: Array<IGen<*>>, posicion: Int): ICromosoma<*> {
        val cromosomaAux = cromosoma.copiar()
        for (i in 0 until cantGenes) {
            if (i > posicion) {
                otroIndividuo[i].copiarA(cromosomaAux.genes[i])
            }
        }
        return cromosomaAux
    }

    fun mutar() {
        cromosoma.mutar(mutacion)
    }

    fun charFitness() {
        var contador = 0
        for (i in 0 until cantGenes) {
            if (genesPropios[i].comparar(cromosoma.objetivo[i])) {
                contador++
            }
        }
        fitness = contador

    }


}
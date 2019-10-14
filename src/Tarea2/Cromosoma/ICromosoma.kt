package Tarea2.Cromosoma

import Tarea2.Genes.IGen

interface ICromosoma<G : IGen<*>> {

    /**
     * arreglo que contiene los genes correspondientes a este cromosoma
     *
     */
    val genes: Array<G>

    /**
     * funcion que genera mutacion en un gen aleatorio del cromosoma
     * @param probMutacion probabilidad de mutacion
     */
    fun mutar(probMutacion: Double)

    /**
     * funcion que permite cambiar genes especificos del cromosoma
     * @param posicion el gen que debe cambiarse
     * @param valor valor por el que se cambiara el gen
     */
    fun cambiarGenEn(posicion: Int, valor: Any)
}
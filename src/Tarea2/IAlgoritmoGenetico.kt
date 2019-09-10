package Tarea2

/**
 * @author Sebastián Donoso
 */

/**
 * Interface que servira como base para la creacion de programas que usen algoritmos geneticos para la busqueda u optimizacion
 * de problemas que se evaluaran durante la realizacion del curso
 */
interface IAlgoritmoGenetico {
    /**
     * metodo que inicializa la poblacion que se ocupara durante la ejecuccion del algoritmo genetico
     * @param cantPoblacion tamaño de la poblacion
     * @param cantGenes cantidad de genes que cada individuo de la poblacion tendra
     */
    fun inicializarPoblacion(cantPoblacion: Int, cantGenes: Int)

    /**
     *metodo que evalua que tan acertado es cada individuo de la poblacion respecto del objetivo
     */
    fun evaluarPoblacion()

    /**
     * metodo que elige cuales son los individuos de la poblacion para reproducirlos posteriormente
     */
    fun seleccion()

    /**
     *metodo que toma los individuos elegidos y los mezcla para generar una nueva poblacion para evaluar
     */
    fun reproduccion()
}
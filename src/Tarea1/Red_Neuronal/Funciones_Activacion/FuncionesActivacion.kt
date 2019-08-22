package Tarea1.Red_Neuronal.Funciones_Activacion


/**
 * Interface base para los distintos tipos de funciones de activacion
 * @author Sebastian Donoso
 */


interface FuncionesActivacion {
    /**
     * Evalua el input dada la funcion de activacion y entrega el resultado
     * @param valor valor a evaluar
     * @return double entre 0 y 1
     */
    fun calcula(valor:Double):Double

    /**
     * Deriva el valor
     * @param valor valor a derivar
     */
    fun derivada(valor:Double):Double
}
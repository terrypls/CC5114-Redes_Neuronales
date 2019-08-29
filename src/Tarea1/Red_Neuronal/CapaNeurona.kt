package Tarea1.Red_Neuronal

import Tarea1.Red_Neuronal.Funciones_Activacion.FuncionesActivacion
import Tarea1.Red_Neuronal.Funciones_Activacion.Sigmoid

/**
 * @author Sebastian Donoso
 */

/**
 * clase que representa a una capa perteneciente a una red neuronal, tiene dos constructores
 * CapaNeurona(cantNeuronas, capaAnterior, funcionesActivacion) crea una nueva capa con la cantidad de neuronas dadas, una referencia
 * a la capa anterior y la funcion de activacion para las neuronas
 * CapaNeurona(cantNeuronas, capaAnterior) crea una capa de neuronas con la funcion de activacion por defecto Sigmoid
 *
 */
class CapaNeurona(
) {

    constructor(
        cantNeuronas: Int,
        capaAnterior: CapaNeurona?,
        funcionesActivacion: FuncionesActivacion) :
            this()
    constructor(cantNeuronas: Int,
                capaAnterior: CapaNeurona?) :
            this(cantNeuronas,
                capaAnterior,
                Sigmoid())

    var capaSiguiente: CapaNeurona? = null

    fun entrenarCapa() {}
    fun aprenderCapa() {}
    fun backPropagationCapa() {}
    /**
     * normaliza un valor al rango [0,1]
     * @param valor valor a normalizar
     * @param min   valor minimo que puede tomar el @param valor
     * @param max valor maximo que puede tomar el @param valor
     * @return valor normalizado
     */
    fun normalizar(valor: Double, min: Double, max: Double): Double {
        return (valor - min) / (max - min)
    }
}
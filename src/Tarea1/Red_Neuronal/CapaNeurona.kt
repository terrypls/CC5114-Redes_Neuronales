package Tarea1.Red_Neuronal

import Tarea1.Red_Neuronal.Funciones_Activacion.FuncionesActivacion
import Tarea1.Red_Neuronal.Funciones_Activacion.Sigmoid

/**
 * @author Sebastian Donoso
 */

/**
 * clase que representa a una capa perteneciente a una red neuronal, tiene dos constructores
 */
class CapaNeurona(
    internal val cantNeuronas: Int,
    internal var capaPrevia: CapaNeurona?
) {
    internal lateinit var neuronas: Array<Neurona>
    internal val salidas = MutableList(cantNeuronas) { .0 }
    internal var capaSiguiente: CapaNeurona? = null

    /**
     *metodo que crea las neuronas asociadas a esta capa con una funcion de activacion especifica
     * @param pesos cantidad de entradas que tendran las neuronas de la capa
     * @param funcionesActivacion funcion de activacion que tendran las neuronas de la capa
     */
    fun crearNeuronas(pesos: Int, funcionesActivacion: FuncionesActivacion = Sigmoid()) {
        neuronas = Array(cantNeuronas) { Neurona(pesos, funcionesActivacion) }
    }

    /**
     * metodo que entrena las neuronas correspondientes a la capa y alimenta a la capa siguiente con los valores obtenidos
     * metodo recursivo
     * @param inputs valores para entrenar la capa
     */
    fun entrenarCapa(inputs: List<Double>): MutableList<Double> {
        assert(::neuronas.isInitialized) { "no se ha inicializado la capa" }
        neuronas.withIndex().forEach { (i, neurona) ->
            salidas[i] = neurona.procesador(inputs)
        }
        return when {
            capaSiguiente != null -> capaSiguiente!!.entrenarCapa(salidas) //si es que quedan mas capas por recorrer
            else -> salidas //si la capa es la ultima dentro de la red
        }
    }

    /**
     * metodo para realizar la primera backPropagation
     * Metodo recursivo
     * @param inputs lista con los valores esperados
     */
    fun backPropagationError(inputs: List<Double>) {
        neuronas.withIndex().forEach { (i, neurona) ->
            val error = inputs[i] - neurona.salida
            neurona.calculoDelta(error)
        }
        capaPrevia?.backPropagationError()

    }

    /**
     * metodo para realizar backpropagation a lo largo de las capas de la red
     * Metodo recursivo
     */
    private fun backPropagationError() {
        neuronas.withIndex().forEach { (i, neurona) ->
            var error = 0.0
            capaSiguiente!!.neuronas.map {
                error += it.calculoErrorPesos(i)
            }
            neurona.calculoDelta(error)
        }
        capaPrevia?.backPropagationError()

    }

    /**
     *metodo para propagar la actualizacion de pesos de la capa
     * metodo recursivo
     * @param inputs valores de entrada que la neurona computo
     */
    fun actualizarPesos(inputs: List<Double>) {
        val entradas: List<Double> = when (capaPrevia) {
            null -> inputs
            else -> capaPrevia!!.salidas
        }
        neuronas.map {
            it.entrenar(entradas)
        }
        capaSiguiente?.actualizarPesos(inputs)
    }



}
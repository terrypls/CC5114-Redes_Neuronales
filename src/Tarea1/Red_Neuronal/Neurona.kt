package Tarea1.Red_Neuronal


import Tarea1.Red_Neuronal.Funciones_Activacion.FuncionesActivacion
import java.nio.DoubleBuffer
import kotlin.random.Random

/**
 * @author Sebastian Donoso
 */

/**
 * clase de neurona generica para usarla dentro de una red neuronal
 * @param pesosEntrada cantidad de pesos que tendra la neurona
 * @param funcion funcion de activacion que tendra la neurona para usar en
 * procesamiento y aprendizaje de esta
 * @param ritmoAprendizaje a que ritmo se quiere que la neurona aprenda
 *
 */

class Neurona(var pesosEntrada: Int, var funcion: FuncionesActivacion, var ritmoAprendizaje: Double) {
    var pesos: Array<Double>
    var bias: Double

    init {
        pesos = Array(pesosEntrada) { Random.nextDouble(-2.0, 2.0) }
        bias = Random.nextDouble(-2.0, 2.0)
    }

    /**
     * metodo que se encarga de procesar los inputs que recibe la neurona
     * @param inputs Lista con valores de entrada de la neurona
     * @return Double entre 0 y 1 que representa el grado de acierto que tuvo la neurona
     */
    fun procesador(inputs: List<Double>): Double {
        var salida = 0.0
        for (i: Int in inputs.indices)
            salida += pesos[i] * inputs[i]
        return funcion.calcula(salida)
    }
    /**
     * modifica bias y pesos de las entradas para reflejar el aprendizaje de la neurona
     * @param inputs Lista con valores de entrada de la neurona
     * @param diferencia  diferencia aritmetica entre el valor esperado y el obtenido por la neurona
     */
    private fun aprender(inputs: List<Double>, diferencia: Double) {
        for (i: Int in pesos.indices) {
            pesos[i] += ritmoAprendizaje * inputs[i] * diferencia
        }
    }
    /**
     * entrena a la neurona con los inputs dados
     * @param inputs: lista con valores de entrada de la neurona
     * @param deseado valor esperado par alos inputs dados
     */
    fun entrenar(inputs: List<Double>, deseado: Double) {
        val real = procesador(inputs)
        aprender(inputs, deseado - real)
    }

}



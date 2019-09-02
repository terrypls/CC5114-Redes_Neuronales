package Tarea1.Ejercicios.Neurona_Sigmoid

import kotlin.math.exp
import kotlin.random.Random

/**
 * Neurona Sigmoide
 * @author Sebastian Donoso Diaz
 */


abstract class AbstractSigmoidNeuron(private val entradas: Int) {
    /* pesos y bias entre -2 y 2 */
    var pesos: Array<Double> = Array(entradas) { Random.nextDouble(-2.0, 2.0) }
    var bias: Double = Random.nextDouble(-2.0, 2.0)
    var learningRate = 0.1

    /**
     * metodo que se encarga de procesar los inputs que recibe la neurona
     * @param input Lista con valores de entrada de la neurona
     * @return Double entre 0 y 1 que representa el grado de acierto que tuvo la neurona
     */
    fun procesador(input: List<Double>): Double {
        var output = 0.0
        for (i: Int in input.indices)
            output += pesos[i] * input[i]

        return (1 / (1 + exp(-(output + bias))))
    }

    /**
     * modifica bias y pesos de las entradas para reflejar el aprendizaje de la neurona
     * @param inputs Lista con valores de entrada de la neurona
     * @param diff  diferencia aritmetica entre el valor esperado y el obtenido por la neurona
     *
     */
    private fun aprender(inputs: List<Double>, diff: Double) {
        for (i: Int in pesos.indices) {
            pesos[i] += learningRate * inputs[i] * diff
        }
        bias += learningRate * diff
    }

    /**
     * entrena a la neurona con los inputs dados
     * @param input: lista con valores de entrada de la neurona
     * @param desireOutput valor esperado del procesamiento de la neurona dado los inputs
     *
     */
    fun entrenar(input: List<Double>, desireOutput: Double) {
        val realOutput = procesador(input)
        aprender(input, desireOutput - realOutput)
    }

}
package Tarea1.Neurona_Sigmoid

import kotlin.math.E

abstract class AbstractSigmoidNeuron(override val pesos: Array<Double>) : Tarea1.Perceptron.AbstractNeurona(pesos) {


    private fun procesador(input: List<Int>, threshold: Double): Int {
        var output = 0.0
        for (i in input.indices)
            output += pesos[i] * input[i]
        val sigma = output + bias
        return when {
            (1 / (1 + E * (-sigma))) > threshold -> 1
            else -> 0
        }
    }


    fun entrenar(input: List<Int>, desireOutput: Int, threshold: Double) {
        val realOutput = procesador(input, threshold)
        aprender(input, desireOutput - realOutput)
    }

}
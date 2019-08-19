package Tarea1.Neurona_Sigmoid

import kotlin.math.exp

abstract class AbstractSigmoidNeuron(val pesos: Array<Double>) {
    private var bias: Double = 0.0
    private val learningRate = 0.1

    private fun procesador(input: List<Double>): Double {
        var output = 0.0
        for (i in input.indices)
            output += pesos[i] * input[i]
        val sigma = output + bias
        return (1 / (1 + exp((-sigma))))
    }

    private fun aprender(inputs: List<Double>, diff: Double) {
        for (i: Int in pesos.indices) {
            pesos[i] += learningRate * inputs[i] * diff
        }
        bias += learningRate * diff
    }

    fun entrenar(input: List<Double>, desireOutput: Double) {
        val realOutput = procesador(input)
        aprender(input, desireOutput - realOutput)
    }

}
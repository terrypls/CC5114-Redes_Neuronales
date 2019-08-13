package Tarea1.Neurona_Sigmoid

import kotlin.math.E

abstract class AbstractSigmoidNeuron(val pesos:Array<Double>):ISigmoidNeuron{
    open var bias = 0.0
    val learningRate = 0.1

    override fun procesador(input: List<Double>): Double {
        var output = 0.0
        for (i in input.indices)
            output += pesos[i] * input[i]
        val sigma = output + bias
        return (1/(1+ E*(-sigma)))
    }

    override fun learning(input: List<Double>, threshold: Double) {
        val realOutput = this.procesador(input)
        val diff = threshold - realOutput
        for (i in pesos.indices)
            pesos[i] = pesos[i] + (learningRate * input[i] * diff)
        bias += learningRate * diff
    }
}
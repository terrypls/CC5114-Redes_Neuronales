package Tarea1.Perceptron

abstract class AbstractPerceptron(val pesos: Array<Double>) : IPerceptron {

    open var bias = 0.0
    private val learningRate = 0.1

    override fun procesador(inputs: List<Int>): Int {

        var output = 0.0
        for (i in inputs.indices)
            output += pesos[i] * inputs[i]

        return when {
            output > bias -> 1
            else -> 0
        }
    }

    override fun learning(inputs: List<Int>, diff: Int) {
        for (i in pesos.indices)
            pesos[i] += learningRate * inputs[i] * diff
        bias += learningRate * diff
    }

    override fun training(inputs: List<Int>, desireOutput: Int) {
        val realOutput = procesador(inputs)
        learning(inputs, desireOutput - realOutput)
    }
}


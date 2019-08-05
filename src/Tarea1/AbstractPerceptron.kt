package Tarea1

abstract class AbstractPerceptron(val pesos: List<Double>, val tolerance: Double) : IPerceptron {

    var bias = 0.0

    override fun procesador(inputs: List<Int>): Int {

        var output = 0.0
        for (i in inputs.indices)
            output += pesos[i] * inputs[i]

        return when {
            output > bias -> 1
            else -> 0
        }
    }

    override fun learning(inputs: List<Double>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    open fun calcBias() {}

}
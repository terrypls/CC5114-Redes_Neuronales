package Tarea1

abstract class AbstractPerceptron(val pesos: List<Double>) : IPerceptron {

    open var bias = 0.0
    var tolerancia = 0.00001

    override fun procesador(inputs: List<Int>): Int {

        var output = 0.0
        for (i in inputs.indices)
            output += pesos[i] * inputs[i]

        return when {
            output + bias + tolerancia > 0 -> 1
            else -> 0
        }
    }

    override fun learning(inputs: List<Double>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
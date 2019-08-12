package Tarea1

abstract class AbstractPerceptron(val pesos: ArrayList<Double>) : IPerceptron {

    open var bias = 0.0
    var tolerancia = 0.00001
    val learningRate = 0.1

    override fun procesador(inputs: List<Int>): Int {

        var output = 0.0
        for (i in inputs.indices)
            output += pesos[i] * inputs[i]

        return when {
            output + bias + tolerancia > 0 -> 1
            else -> 0
        }
    }

    override fun learning(inputs: List<Int>, desireOutput: Int) {
        val realOutput = this.procesador(inputs)
        val diff = desireOutput - realOutput
        for (i in pesos.indices)
            pesos[i] = pesos[i] + (learningRate * inputs[i] * diff)
        bias += learningRate * diff


    }


}
package Tarea1.Ejercicios.Perceptron



abstract class AbstractNeuron(open val pesos: Array<Double>){

    open var bias = 0.0
    private val learningRate = 0.1

     fun procesador(inputs: List<Int>): Int {

        var output = 0.0
        for (i in inputs.indices)
            output += pesos[i] * inputs[i]

        return when {
            output + bias > 0 -> 1
            else -> 0
        }
    }

     fun aprender(inputs: List<Int>, diff: Int) {
        for (i in pesos.indices)
            pesos[i] += learningRate * inputs[i] * diff
        bias += learningRate * diff
    }

     fun entrenar(inputs: List<Int>, desireOutput: Int) {
        val realOutput = procesador(inputs)
        aprender(inputs, desireOutput - realOutput)
    }
}



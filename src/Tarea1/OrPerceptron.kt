package Tarea1

class OrPerceptron(pesos: List<Double>, val tolerancia: Double) : AbstractPerceptron(pesos, tolerancia) {

    override fun calcBias() {
        bias = pesos.min()!! - tolerancia
    }
}
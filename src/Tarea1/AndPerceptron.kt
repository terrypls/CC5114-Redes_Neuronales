package Tarea1

class AndPerceptron(pesos: List<Double>, val tolerancia:Double) : AbstractPerceptron(pesos,tolerancia) {

    override fun calcBias() {
        bias = pesos.sum()-tolerancia
    }

}
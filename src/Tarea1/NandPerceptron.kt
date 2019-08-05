package Tarea1

class NandPerceptron(pesos: List<Double>, val tolerancia: Double) : AbstractPerceptron(pesos, tolerancia){

    override fun calcBias() {
        bias = (pesos.sum() - tolerancia)*-1
    }
}

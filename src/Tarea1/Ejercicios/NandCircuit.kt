package Tarea1.Ejercicios

class NandCircuit {

    val pesos = arrayOf(-2.0, -2.0)
    val percep1 = NandPerceptron(pesos, 3.0)
    val percep2 = NandPerceptron(pesos, 3.0)
    val percep3 = NandPerceptron(pesos, 3.0)
    val sum = NandPerceptron(pesos, 3.0)
    val carry = NandPerceptron(pesos, 3.0)

    var carrydigit = 0

    fun suma(x1: Int, x2: Int): Int {
        val resul1 = percep1.procesador(listOf(x1, x2))
        val resul2 = percep2.procesador(listOf(x1, resul1))
        val resul3 = percep3.procesador(listOf(resul1, x2))
        carrydigit = carry.procesador(listOf(resul1, resul1))
        return sum.procesador(listOf(resul3, resul2))
    }
}
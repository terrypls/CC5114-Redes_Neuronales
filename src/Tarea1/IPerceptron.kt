package Tarea1

interface IPerceptron {
    fun procesador(inputs: List<Int>): Int
    fun learning(inputs: List<Int>, desireOutput: Int)
}
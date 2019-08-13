package Tarea1.Perceptron

interface IPerceptron {
    fun procesador(inputs: List<Int>): Int
    fun aprender(inputs: List<Int>, diff: Int)
    fun entrenar(inputs: List<Int>, desireOutput: Int)
}
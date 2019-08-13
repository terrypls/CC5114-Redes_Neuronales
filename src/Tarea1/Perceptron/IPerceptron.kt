package Tarea1.Perceptron

interface IPerceptron {
    fun procesador(inputs: List<Int>): Int
    fun learning(inputs: List<Int>, diff: Int)
    fun training(inputs:List<Int>,desireOutput:Int)
}
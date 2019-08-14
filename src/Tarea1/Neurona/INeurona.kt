package Tarea1.Neurona

interface INeurona {
    fun procesador(inputs: List<Int>): Int
    fun aprender(inputs: List<Int>, diff: Int)
    fun entrenar(inputs: List<Int>, desireOutput: Int)
}
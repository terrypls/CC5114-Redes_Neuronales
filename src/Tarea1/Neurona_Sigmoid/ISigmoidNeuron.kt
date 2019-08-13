package Tarea1.Neurona_Sigmoid

interface ISigmoidNeuron {
    fun procesador(input:  List<Double>):Double
    fun learning(input: List<Double>,threshold:Double)

}
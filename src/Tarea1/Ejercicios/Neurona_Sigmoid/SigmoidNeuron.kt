package Tarea1.Ejercicios.Neurona_Sigmoid

/**
 * @author Sebastian Donoso
 * alias: terrypls
 */


/**
 * clase sigmoidneuron para ser llamada
 */
class SigmoidNeuron(entradas: Int):AbstractSigmoidNeuron(entradas) {

    fun threshold(input:Double,threshold:Double):Int{
        return when{
            input>threshold -> 1
            else -> 0
        }
    }
}
package Tarea1.Red_Neuronal


import Tarea1.Red_Neuronal.Funciones_Activacion.FuncionesActivacion
import Tarea1.Red_Neuronal.Funciones_Activacion.Sigmoid
import java.nio.DoubleBuffer
import kotlin.random.Random
import kotlin.random.Random.Default.nextDouble

/**
 * @author Sebastian Donoso
 */

/**
 * clase de neurona generica para usarla dentro de una red neuronal, tiene dos construcctores para cuando se asgina la
 * funcion de activacion y cuando no
 * Neurona(pesosEntrada,funcion) crea neurona con pesos aleatorios entre [-2, 2] con la funcion de activacion dada
 * Neurona(pesosEntrada) crea neurona sigmoid por defecto con pesos aleatorios entre [-2, 2] debido a que se tiene considerado
 * que esta red neuronal se usara principalmente para clasificacion
 */

class Neurona(
    internal var pesos: MutableList<Double>,
    internal val funcion: FuncionesActivacion,
    internal var bias: Double = nextDouble(-2.0, 2.0)
) {

    constructor(
        pesosEntrada: Int,
        funcion: FuncionesActivacion
    ) : this(
        MutableList(pesosEntrada) { _ -> nextDouble(-2.0, 2.0) },
        funcion
    )

    constructor(pesosEntrada: Int) : this(pesosEntrada, Sigmoid())

    private val ritmoAprendizaje: Double = 0.1
    internal var salida: Double = 0.0
    var delta: Double = 0.0


    /**
     * metodo que se encarga de procesar los inputs que recibe la neurona y entregar la prediccion de esta
     * @param inputs Lista con valores de entrada de la neurona
     * @return Double entre 0 y 1 que representa el grado de acierto que tuvo la neurona
     */
    fun procesador(inputs: List<Double>): Double {
        assert(inputs.size == pesos.size) { "pesos y largo de inputs no calzan" }
        val entrega = pesos.indices.sumByDouble { pesos[it] * inputs[it] }
        salida = funcion.calcula(entrega + bias)
        return salida
    }

    /**
     * modifica bias y pesos de las entradas para reflejar el aprendizaje de la neurona
     * @param inputs Lista con valores de entrada de la neurona
     */
    fun entrenar(inputs: List<Double>) {
        for (i: Int in pesos.indices) {
            pesos[i] += ritmoAprendizaje * inputs[i] * delta
        }
        bias += ritmoAprendizaje * delta
    }

    /**
     * calculo de la variacion de los pesos/bias para la neurona
     * @param diferencia diferencia entre salida deseada y real
     */
    internal fun calculoDelta(diferencia: Double) {
        delta = diferencia * funcion.derivada(salida)
    }

    /**
     * funcion aux para calculo de error para backpropagation
     * @param indice indice en la lista del peso que se esta evaluando
     */
    fun calculoErrorPesos(indice: Int): Double {
        return pesos[indice] * delta
    }

}



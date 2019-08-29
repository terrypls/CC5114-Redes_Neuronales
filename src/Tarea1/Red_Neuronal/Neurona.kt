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
 * Neurona(pesosEntrada,funcion) crea neurona con pesos aleatorios entre [-1, 1] con la funcion de activacion dada
 * Neurona(pesosEntrada) crea neurona sigmoid por defecto con pesos aleatorios entre [-1, 1] debido a que se tiene considerado
 * que esta red neuronal se usara principalmente para clasificacion
 */

class Neurona(
    private var pesos: MutableList<Double>,
    private val funcion: FuncionesActivacion,
    private var bias: Double = nextDouble(-1.0, 1.0)
) {

    constructor(
        pesosEntrada: Int,
        funcion: FuncionesActivacion
    ) : this(
        MutableList(pesosEntrada) { _ -> nextDouble(-1.0, 1.0) },
        funcion
    )

    constructor(pesosEntrada: Int) : this(pesosEntrada, Sigmoid())

    private val ritmoAprendizaje: Double = 0.01
    private var salida: Double = 0.0
    private var delta: Double = 0.0


    /**
     * metodo que se encarga de procesar los inputs que recibe la neurona
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
    private fun aprender(inputs: List<Double>) {
        for (i: Int in pesos.indices) {
            pesos[i] += ritmoAprendizaje * inputs[i] * delta
        }
        bias += ritmoAprendizaje * delta
    }

    /**
     * entrena a la neurona con los inputs dados
     * @param inputs: lista con valores de entrada de la neurona
     * @param deseado valor esperado para los inputs dados
     */
    fun entrenar(inputs: List<Double>, deseado: Double) {
        val real = procesador(inputs)
        calculoDelta(real - deseado)
        aprender(inputs)
    }

    /**
     * calculo de la variacion de los pesos/bias para la neurona
     * @param diferencia diferencia entre salida deseada y real
     */
    fun calculoDelta(diferencia: Double) {
        delta = diferencia * funcion.derivada(salida)
    }

}



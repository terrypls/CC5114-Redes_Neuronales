package Tarea1.Red_Neuronal

import kotlin.math.abs
import kotlin.math.max
import kotlin.random.Random

/**
 * @author Sebastian Donoso
 */

/**
 * clase que se encarga de la creacion de una red neuronal
 * @param numeroCapas cantidad de capas de la red neuronal
 * @param neuronasPorCapa especifica la cantidad de neuronars presentes en cada una de las capas
 * @param entradas cantidad de valores de entradas que soportara la red
 * @param salidas cantidad de valores de salida que se espera que tenga la red
 */
class RedNeuronal(
    private val numeroCapas: Int,
    private val neuronasPorCapa: List<Int>,
    private val entradas: Int,
    private val salidas: Int
) {
    internal var valor: MutableList<Double> = mutableListOf()
    private lateinit var capas: Array<CapaNeurona?>
    var precision: MutableList<Double> = mutableListOf()
    //lista para almacenar los set de datos suministrados a la red
    internal val data: MutableList<DataSet> = mutableListOf()
    var eleccion:Int = 0


    init {
        this.crearRed()
    }

    /**
     * clase interna para guardar informacion sobre los set de datos que se le suministraran a la red para entrenamiento
     * @param inputs valores entregados a la red
     * @param outputs valores esperados de la red
     */
    internal data class DataSet(val inputs: List<Double>, val outputs: List<Double>)


    /**
     * metodo para agregar un nuevo set de datos/respuesta para entrenar la red
     * @param inputs valores suministrados a la red
     * @param outputs valores esperados de la red
     */
    fun agregarSet(inputs: List<Double>, outputs: List<Double>) {
        data.add(DataSet(inputs, outputs))
    }


    /**
     * metodo que crea la red neuronal con los parametros dados por defecto al momento de armar la red, por defecto es una red
     * hecha a partir de neuronas de tipo sigmoids
     */
    fun crearRed() {
        assert(numeroCapas > 0) { "la red debe tener al menos 1 capa" }
        assert(neuronasPorCapa.last() == salidas) { "Cantidad de neuronas en la salidad no concuerda con el input dado" }
        //crea el arreglo en donde se guardaran las capas
        capas = arrayOfNulls(numeroCapas)
        capas.withIndex().forEach { (i, capa) ->
            capas[i] = CapaNeurona(
                neuronasPorCapa[i],
                capaPrevia = when {
                    i - 1 < 0 -> null
                    else -> capas[i - 1]
                }
            )
            //creamos las neuronas de cada una de las capas
            capas[i]!!.crearNeuronas(
                pesos = when {
                    capas[i]!!.capaPrevia != null -> capas[i]!!.capaPrevia!!.salidas.size
                    else -> entradas
                }
            )

        }
        capas.withIndex().forEach { (i, capa) ->
            //le dice a cada capa quien es su siguiente
            capas[i]!!.capaSiguiente = when (i) {
                numeroCapas - 1 -> null
                else -> capas[i + 1]
            }

        }
    }

    fun elige(inputs: List<Double>): Int {
        alimentarRed(inputs)
        valor = capas.last()!!.salidas


        return valor.indexOf(valor.max())
    }

    /**
     * metodo para entrenar la red una cantidad definida de veces tomando un conjunto input/output definido en la clase
     * dataSet
     * @param repeticiones cantidad de veces que se entrenara
     */
    fun entrenarRed(repeticiones: Int) {
        for (i in 0 until repeticiones) {
            var acierto = 0.toDouble()

            data.shuffle()//desordenamos la lista
            data.forEach { (input, output) ->
                entrenarRed(input, output)

                if (abs((valor[eleccion] - output[output.indexOf(output.max())]))<0.01) {
                    acierto++}
            }


            precision.add(acierto / (data.size * 100))
        }

    }

    fun entrenarRed(inputs: List<Double>, outputs: List<Double>) {
        eleccion = elige(inputs)
        backPropagationError(outputs)
        actualizarPesos(inputs)
    }

    fun alimentarRed(inputs: List<Double>) {
        capas.first()!!.entrenarCapa(inputs)
    }

    fun backPropagationError(esperado: List<Double>) {
        capas.last()!!.backPropagationError(esperado)
    }

    fun actualizarPesos(inputs: List<Double>) {
        capas.first()!!.actualizarPesos(inputs)
    }

    /**
     * normaliza un valor al rango [0,1]
     * @param valor valor a normalizar
     * @param min   valor minimo que puede tomar el @param valor
     * @param max valor maximo que puede tomar el @param valor
     * @return valor normalizado
     */
    fun normalizar(valor: Double, min: Double, max: Double): Double {
        return (valor - min) / (max - min)
    }

}
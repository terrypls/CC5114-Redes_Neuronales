package Tarea1.Red_Neuronal

import javax.xml.crypto.Data
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
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
    //variables para estadisticas de entrenamiento
    var precision: MutableList<Double> = mutableListOf()
    var calculoErro: MutableList<Double> = mutableListOf()

    //variables para estadisticas de prueba
    var pruebaPrecision: MutableList<Double> = mutableListOf()
    var pruebaError: MutableList<Double> = mutableListOf()
    var recuento: MutableList<Pair<Int, Int>> = mutableListOf()

    //lista para almacenar los set de datos suministrados a la red
    internal val data: MutableList<DataSet> = mutableListOf()
    internal val test: MutableList<DataSet> = mutableListOf()
    var eleccion: Int = 0


    init {
        require(numeroCapas == neuronasPorCapa.size)
        this.crearRed()
    }

    /**
     * clase interna para guardar informacion sobre los set de datos que se le suministraran a la red para entrenamiento
     * @param inputs valores entregados a la red
     * @param outputs valores esperados de la red
     */
    internal data class DataSet(val inputs: List<Double>, val outputs: List<Double>)


    /**
     * clase interna para guardar los set sobre los cuales se realizaran las pruebas de eficacia sobre la red
     * @param inputs valores entregados a la red
     * @param outputs valores esperados de la red
     */
    fun agregarTest(inputs: List<Double>, outputs: List<Double>) {
        test.add(DataSet(inputs, outputs))
    }

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
        capas.withIndex().forEach { (i, _) ->
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
        capas.withIndex().forEach { (i, _) ->
            //le dice a cada capa quien es su siguiente
            capas[i]!!.capaSiguiente = when (i) {
                numeroCapas - 1 -> null
                else -> capas[i + 1]
            }

        }
    }

    /**
     * metodo que elige cual de las posibles respuestas es la correcta
     * @param inputs datos suministrdos a la red
     * @return indice elegido en el vector de salida como respuesta correcta
     */
    fun elige(inputs: List<Double>): Int {
        alimentarRed(inputs)
        valor = capas.last()!!.salidas
        return valor.indexOf(valor.max())
    }

    /**
     * metodo para entrenar la red una cantidad definida de veces tomando un conjunto input/output definido en la clase
     * dataSet
     * genera informacion sobre la precision y error cuadratico media de la red
     * @param repeticiones cantidad de veces que se entrenara
     */
    fun entrenarRed(repeticiones: Int) {
        for (i in 0 until repeticiones) {
            var acierto = 0.toDouble()
            var error: Double = .0
            data.shuffle()//desordenamos la lista
            data.forEach { (input, output) ->
                entrenarRed(input, output)
                if (eleccion == output.indexOf(output.max())) acierto++
                else {
                    //error++
                    error += (eleccion - output.indexOf(output.max())).toDouble().pow(2)
                }
            }
            calculoErro.add(error / data.size * 100)
            precision.add(acierto / data.size * 100)
        }
    }

    /**
     * metodo similar a entrenarRed, pero dedicado a procesar los datos guardados para testeo
     * genera informacion sobre la precision y error cuadratico media de la red
     * Cantidad de iteraciones sobre los test
     */
    fun probarRed(repeticiones: Int) {
        for (i in 0 until repeticiones) {
            var acierto = 0.toDouble()
            var erroractual: Double
            var error: Double = .0
            test.shuffle()//desordenamos la lista
            test.forEach { (inputs, output) ->
                eleccion = elige(inputs)
                if (eleccion == output.indexOf(output.max())) acierto++
                else {
                    //error++
                    error += (eleccion - output.indexOf(output.max())).toDouble().pow(2)
                }

                recuento.add(Pair(eleccion, output.indexOf(output.max())))
            }
            pruebaError.add(error / test.size * 100)
            pruebaPrecision.add(acierto / test.size * 100)

        }
    }

    /**
     * metodo que se encarga de elegir un resultado y generar la propagacion de errores y actualizacion de pesos
     * @param inputs entradas para la red neuronal
     * @param outputs valores esperados de salida
     */
    private fun entrenarRed(inputs: List<Double>, outputs: List<Double>) {
        eleccion = elige(inputs)
        backPropagationError(outputs)
        actualizarPesos(inputs)
    }

    /**
     * metodo que se encarga de proveer a la primera capa de la red con los inputs recibidos
     * @param inputs entradas para la red neuronal
     */
    fun alimentarRed(inputs: List<Double>) {
        capas.first()!!.entrenarCapa(inputs)
    }

    /**
     * metodo que genera la propagacion de errores en la red desde la ultima capa de la red
     * @param esperado valores esperados de salida de la red
     */
    private fun backPropagationError(esperado: List<Double>) {
        capas.last()!!.backPropagationError(esperado)
    }

    /**
     * metodo que inicia la actualizacion de pesos en la primera capa de la red
     * @param inputs entradas para la red neuronal
     */
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
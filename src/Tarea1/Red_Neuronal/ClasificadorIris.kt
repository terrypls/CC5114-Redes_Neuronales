package Tarea1.Red_Neuronal

import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException

/**
 * clasificador para clasificar 3 tipos de platas segun informacion de su iris
 * dataset para entrenar y probar la red fue sacada de la siguiente direccion:
 *  https://archive.ics.uci.edu/ml/datasets/Iris
 */

class ClasificadorIris (val nombreArchivo:String,val  numEntrenamientos:Int){
    private lateinit var sepalLength:List<Double>
    private lateinit var sepalWidth:List<Double>
    private lateinit var petalLength:List<Double>
    private lateinit var petalWidth:List<Double>

    var diccionario  = mapOf("Iris-setosa" to 0,"Iris-versicolor" to 1,"Iris-virginica" to 2)

    fun procesarDatos()  {

        var reader: BufferedReader? = null
        try {
            reader = File(nombreArchivo).bufferedReader()
            val lines = mutableListOf<String>()
            reader.useLines { line -> line.forEach { lines.add(it) } }
            for (line in lines) {
                val aux = line.split(",")

            }


        } catch (e: FileNotFoundException) {
            print("File not found.")
        } finally {
            if (reader != null) reader.close()
            else System.exit(-1)
        }
    }

    /**
     * metodo para graficar los resultados esperados
     */
    fun graficar(){}
}
fun main(){

    val clasificador = ClasificadorIris("Tarea1/DataSet/iris.data",100)
    clasificador.graficar()
}
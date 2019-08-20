package Extras

import kotlin.random.Random

/**
 * clase con metodos utiles para generar testeos
 */
class Utils {
    /**
     * comprueba si el par (x,y) estan por arriba o abajo de la recta
     * @param x posicion x
     * @param y posicion y
     * @param Recta la con la que se esta comparando
     */
    fun check(x: Int, y: Int, Recta: Recta): Int {
        return when {
            Recta.a * x + Recta.b > y -> 1
            else -> 0
        }

    }

    /**
     * crea puntos al azar y los almacena en un array
     * @param numberPoints cantidad de puntos a generar
     * @param ancho maximo x
     * @param largo maximo y
     * @param Recta Recta para comparar
     * @return Array(Pair(Lista(int),Int)) con par interno lista de valores y valor esperado
     */
    fun crearPuntos(numberPoints: Int, ancho: Int, largo: Int, Recta: Recta): Array<Pair<List<Int>, Int>> {

        return Array(numberPoints) {
            val x: Int = Random.nextInt(-ancho, ancho)
            val y: Int = Random.nextInt(-largo, largo)
            val salidaDeseada: Int = check(x, y, Recta)
            Pair(listOf(x, y), salidaDeseada)
        }
    }
}

/**
 * clase recta para testeors
 */
class Recta(val a: Int, val b: Int) {
    //y = a*x + b
}
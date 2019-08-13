package Extras

import kotlin.random.Random

class Utils {

    fun check(x: Int, y: Int, recta: recta): Int {
        return when {
            recta.a * x + recta.b > y -> 1
            else -> 0
        }

    }

    fun crearPuntos(numberPoints: Int, ancho: Int, largo: Int, recta: recta): Array<Pair<List<Int>, Int>> {

        return Array(numberPoints) {
            val x: Int = Random.nextInt(-ancho, ancho)
            val y: Int = Random.nextInt(-largo, largo)
            val salidaDeseada: Int = check(x, y, recta)
            Pair(listOf(x, y), salidaDeseada)
        }
    }
}

class recta(val x: Int, val y: Int, val a: Int, val b: Int) {
    //y = a*x + b
}
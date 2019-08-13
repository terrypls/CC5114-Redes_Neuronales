package Extras

import kotlin.random.Random

class Utils {

    fun check(x: Int, y: Int, Recta: Recta): Int {
        return when {
            Recta.a * x + Recta.b > y -> 1
            else -> 0
        }

    }

    fun crearPuntos(numberPoints: Int, ancho: Int, largo: Int, Recta: Recta): Array<Pair<List<Int>, Int>> {

        return Array(numberPoints) {
            val x: Int = Random.nextInt(-ancho, ancho)
            val y: Int = Random.nextInt(-largo, largo)
            val salidaDeseada: Int = check(x, y, Recta)
            Pair(listOf(x, y), salidaDeseada)
        }
    }
}

class Recta(val a: Int, val b: Int) {
    //y = a*x + b
}
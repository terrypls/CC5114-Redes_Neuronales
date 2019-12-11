package Tarea3.Nodos


import kotlin.reflect.jvm.reflect

// util fun desde https://kotlinlang.org/docs/reference/reflection.html
// sirve para entregar info de la funcion, como el nombre, o sus parametros
fun funArgsCount(aFun: Function<Any>): Int {
    return aFun.reflect()!!.parameters.size
}

/**
 * clase base para todos los nodos que usaran el GP
 */
open class Nodo(
    var operacion: ((Nodo, Nodo) -> Int)?
) {
    var argumentos: MutableList<Nodo> = mutableListOf<Nodo>() // lista para guardar referencias a los hijos
    open var numArgumentos = when (operacion) {
        null -> 0
        else -> funArgsCount(operacion!!)
    }

    open fun eval(): Int {
        assert(argumentos.size == numArgumentos) { "there is something bad, harry" }
        assert(operacion != null) { "llego un null aqui" }
        return this.operacion!!(argumentos.first(), argumentos.last())
    }

    fun serializar(): MutableList<Any> {
        val lista: MutableList<Any> = mutableListOf(this)
        this.argumentos.map {
            lista.add(it.serializar())
        }
        return lista
    }

    fun copiar(): Nodo {
        val aNodo = Nodo(this.operacion)
        aNodo.argumentos = this.argumentos
        return aNodo
    }

    fun reemplazar(otroNodo: Nodo) {
        this.operacion = otroNodo.operacion
        this.argumentos = otroNodo.argumentos
        this.numArgumentos = otroNodo.numArgumentos

    }

}


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
    var operacion: ((Nodo, Nodo) -> Int)?,
    var profundidad: Int? = 0
) {

    var argumentos: MutableList<Nodo> = mutableListOf<Nodo>() // lista para guardar referencias a los hijos
    open var numArgumentos = when (operacion) {
        null -> 0
        else -> 2 // todos los nodos son binarios
    }

    /**
     * metodo recursivo que evalua el nodo en base a la funcion provista
     * @return el resultado de la evaluacion
     */
    open fun eval(): Int {
        assert(argumentos.size == numArgumentos) { "there is something bad, harry" }
        assert(operacion != null) { "llego un null aqui" }
        return this.operacion!!(argumentos.first(), argumentos.last())
    }

    fun serializar(): MutableList<Nodo> {
        val list: MutableList<Nodo> = mutableListOf(this)
        for (node in this.argumentos) {
            list.addAll(node.serializar())
        }
        return list
    }

    open fun copiar(): Nodo {
        val aNodo = Nodo(this.operacion, profundidad)
        aNodo.argumentos = mutableListOf()
        this.argumentos.forEach { aNodo.argumentos.add(it.copiar()) }
        return aNodo
    }

    fun reemplazar(otroNodo: Nodo) {
        this.operacion = otroNodo.operacion
        this.argumentos = otroNodo.argumentos
        this.numArgumentos = otroNodo.numArgumentos

    }

}


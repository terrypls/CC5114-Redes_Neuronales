package Tarea3.Nodos

/**
 * nodo que representa un nodo binario, con referencias a sus hijos izquierdo y derecho
 */
open class NodoBinario(
    operacion: (Nodo, Nodo) -> Int,
    var nodoIzq: Nodo,
    var nodoDer: Nodo,
    private val profundida: Int? = 0
) : Nodo(operacion = operacion, profundidad = profundida) {
    override var numArgumentos = 2

    init {
        super.argumentos.add(nodoIzq)
        super.argumentos.add(nodoDer)
    }

    override fun toString(): String {
        return operacion.toString()
    }

}
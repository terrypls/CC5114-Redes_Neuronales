package Tarea3.Nodos


/**
 * clase que representa un nodo terminal(hoja)
 */
class NodoTerminal(

    override var valor: Int,
    private val profundo: Int
) : Nodo(null, 0) {

    override fun eval(): Int {
        return valor
    }

    override fun copiar(): Nodo {
        return NodoTerminal(valor, profundidad)
    }

    override fun toString(): String {
        return this.valor.toString()
    }


}

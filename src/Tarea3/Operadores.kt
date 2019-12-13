package Tarea3

import Tarea3.Nodos.Nodo
import kotlin.math.max


class Suma : (Nodo, Nodo) -> Int {

    override fun invoke(a: Nodo, b: Nodo): Int {
        return a.eval() + b.eval()
    }

    override fun toString(): String = "+"
}

class Resta : (Nodo, Nodo) -> Int {
    override fun invoke(a: Nodo, b: Nodo): Int = a.eval() - b.eval()
    override fun toString(): String = "-"
}

class Multi : (Nodo, Nodo) -> Int {
    override fun invoke(a: Nodo, b: Nodo): Int = a.eval() * b.eval()
    override fun toString(): String = "*"
}

class Div : (Nodo, Nodo) -> Int {
    override fun invoke(a: Nodo, b: Nodo): Int {
        return when (b.eval()) {
            0 -> throw ArithmeticException("no se puede dividir por 0 o el mundo explota")
            else -> a.eval() / b.eval()
        }
    }

    override fun toString(): String = "/"
}

class Max : (Nodo, Nodo) -> Int {
    override fun invoke(a: Nodo, b: Nodo): Int = max(a.eval(), b.eval())
    override fun toString(): String = "max"
}

package Tarea3

import Tarea3.Nodos.Nodo
import kotlin.math.max

class Suma(val a: Nodo, val b: Nodo) : (Nodo, Nodo) -> Int {
    override fun invoke(a: Nodo, b: Nodo): Int = a.eval() + b.eval()
    override fun toString(): String = "${this.a} + ${this.b}"
}

class Resta(val a: Nodo, val b: Nodo) : (Nodo, Nodo) -> Int {
    override fun invoke(a: Nodo, b: Nodo): Int = a.eval() - b.eval()
    override fun toString(): String = "${this.a} - ${this.b}"
}

class Multi(val a: Nodo, val b: Nodo) : (Nodo, Nodo) -> Int {
    override fun invoke(a: Nodo, b: Nodo): Int = a.eval() * b.eval()
    override fun toString(): String = "${this.a} * ${this.b}"
}

class Div(val a: Nodo, val b: Nodo) : (Nodo, Nodo) -> Int {
    override fun invoke(a: Nodo, b: Nodo): Int {
        return when (b.eval()) {
            0 -> throw ArithmeticException("no se puede dividir por 0 o el mundo explota")
            else -> a.eval() / b.eval()
        }
    }

    override fun toString(): String = "${this.a} / ${this.b}"
}

class Max(val a: Nodo, val b: Nodo) : (Nodo, Nodo) -> Int {
    override fun invoke(a: Nodo, b: Nodo): Int = max(a.eval(), b.eval())
    override fun toString(): String = "${this.a} + ${this.b}"
}

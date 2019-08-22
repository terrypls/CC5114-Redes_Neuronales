package Tarea1.Red_Neuronal.Funciones_Activacion

import kotlin.math.exp
import kotlin.math.pow

class Tanh:FuncionesActivacion {
    override fun calcula(valor: Double): Double {
        return((exp(valor)- exp(-valor))/(exp(valor)+ exp(-valor)))
    }

    override fun derivada(valor: Double): Double {
        return (1 - this.calcula(valor).pow(2))
    }
}
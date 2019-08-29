package Tarea1.Red_Neuronal

import Tarea1.Red_Neuronal.Funciones_Activacion.FuncionesActivacion
import Tarea1.Red_Neuronal.Funciones_Activacion.Sigmoid

class RedNeuronal(
    private val capas: Int,
    private val neuronasPorCapa: List<Int>,
    private val entradas: Int,
    private val salidas: Int,
    private val epoch: Int
) {

    fun construirRed() {
        assert(capas > 0 ){"Neurona sin capas :O "}
        var capasRed = arrayOfNulls<CapaNeurona>(capas)

    }
    fun entrenarRed() {}
    fun aprenderRed() {}
    fun backPropagation() {}
    //TODO crear capas de la neurona
}
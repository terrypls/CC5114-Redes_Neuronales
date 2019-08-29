package Tarea1.Red_Neuronal

import Tarea1.Red_Neuronal.Funciones_Activacion.FuncionesActivacion

class CapaNeurona(
    val cantNeuronas: Int,
    var capaAnterior: CapaNeurona?
) {
    var capaSiguiente: CapaNeurona? = null
    //TODO definir los argumentos que tiene que recibir la capa de la neurona

    fun crearCapa() {}
    fun entrenarCapa() {}
    fun aprenderCapa() {}
    fun backPropagationCapa() {}
    /**
     * normaliza un valor al rango [0,1]
     * @param valor valor a normalizar
     * @param min   valor minimo que puede tomar el @param valor
     * @param max valor maximo que puede tomar el @param valor
     * @return valor normalizado
     */
    fun normalizar(valor:Double,min:Double,max:Double):Double{
        return (valor-min)/(max-min)
    }
}
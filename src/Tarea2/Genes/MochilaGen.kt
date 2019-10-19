package Tarea2.Genes

import kotlin.random.Random

class MochilaGen : IGen<Pair<Int, Int>> {


    override var alelo: Pair<Int, Int>

    constructor(opciones: Array<Pair<Int, Int>>) {
        alelo = opciones[Random.nextInt(opciones.size)]
    }

    constructor(valor: Pair<Int, Int>) {
        alelo = valor
    }

    override fun copiarA(otroGen: IGen<*>) {
        otroGen.copiarDesdeMochilaGen(this)
    }

    override fun copiarDesdeMochilaGen(otroGen: MochilaGen) {
        alelo = otroGen.alelo
    }

    override fun copiarDesdeCharGen(otroGen: CharGen) {
        //vacio
    }

    override fun comparar(otroGen: Any): Boolean {
        val algo: MochilaGen = otroGen as MochilaGen
        return algo.alelo.first == this.alelo.first && algo.alelo.second == this.alelo.second
    }

    override fun copiarGen(): IGen<*> {
        return MochilaGen(alelo)
    }

    /**
     * funcion que sirve para cambiar a mano el valor del alelo en el gen
     */
    fun cambiarGen(valor: Pair<Int, Int>) {
        alelo = valor
    }

}
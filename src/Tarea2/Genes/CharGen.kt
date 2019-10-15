package Tarea2.Genes

import kotlin.random.Random

/**
 * clase  para la generacion de genes con un char como informacion
 */
class CharGen : IGen<Char> {


    override var alelo: Char = ' '

    private var alfabeto: String

    /**
     * crea un gen nuevo aleatorio dado un alfabeto
     * @param base alfabeto a utilizar
     */
    constructor(base: String) {
        alfabeto = base
        alelo = alfabeto[Random.nextInt(alfabeto.length)]

    }

    /**
     * crea un nuevo gen a partir de un caracter en particular
     * @param base alfabeto a utilizar
     * @param caracter el caracter base del gen
     */
    constructor(base: String, caracter: Char) {
        alfabeto = base
        alelo = caracter
    }

    override fun copiarGen(): IGen<*> {
        return CharGen(alfabeto, alelo)
    }

    override fun copiarA(otroGen: IGen<*>) {
        otroGen.copiarDesdeCharGene(this)
    }

    override fun copiarDesdeCharGene(otroGen: CharGen) {
        alelo = otroGen.alelo
        alfabeto = otroGen.alfabeto
    }


    override fun comparar(otroGen: Any): Boolean {
        val algo: CharGen = otroGen as CharGen
        return algo.alelo == this.alelo && algo.alfabeto == this.alfabeto
    }

    /**
     * funcion que sirve para cambiar a mano el valor del alelo en el gen
     */
    fun cambiarGen(caracter: Char) {
        alelo = caracter
    }


}
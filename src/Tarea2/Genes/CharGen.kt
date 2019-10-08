package Tarea2.Genes

import kotlin.random.Random

/**
 * clase  para la generacion de genes con un char como informacion
 */
class CharGen : IGen<Char> {
    override var alelo: Char = ' '

    internal var alfabeto: String

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

    override fun copiarA(otroGen: IGen<*>) {
        otroGen.copiarDesdeCharGene(this)
    }

    override fun copiarDesdeCharGene(otroGen: CharGen) {
        alelo = otroGen.alelo
        alfabeto = otroGen.alfabeto
    }

    /**
     * funcion que revisa si dos genes son iguales
     * @param otroGen gen con el que se comparara si son iguales
     */
    override fun equals(otroGen: Any?): Boolean {
        return otroGen is CharGen && this.alelo == otroGen.alelo && this.alfabeto == otroGen.alfabeto
    }

    /**
     * funcion que retorna el hash code de un objeto
     */
    override fun hashCode(): Int {
        var result = alelo.hashCode()
        result = 31 * result + alfabeto.hashCode()
        return result
    }

    /**
     * funcion que sirve para cambiar a mano el valor del alelo en el gen
     */
    fun cambiarGen(caracter: Char) {
        alelo = caracter
    }


}
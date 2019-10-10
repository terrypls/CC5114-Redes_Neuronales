package Tarea2.Genes

/**
 * interfaz comun que compartiran los genes
 */
interface IGen<out Alelo> {

    /**
     * variable que guardara el valor del gen
     */
    val alelo: Alelo

    /**
     * funcion que permite copiar el valor del gen actual a otro gen
     * @param otroGen el gen que sera modificado
     */
    fun copiarA(otroGen: IGen<*>)

    /**
     * funcion que permite sobreescribir la informacion del gen actual por la de otro gen
     * @param otroGen el gen que provee la informacion
     */
    fun copiarDesdeCharGene(otroGen: CharGen)

    /**
     * funcion para comparar el contenido de dos genes
     */

    fun comparar(otroGen: CharGen): Boolean


}
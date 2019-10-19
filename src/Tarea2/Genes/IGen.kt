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
     * funcion que permite sobreescribir la informacion del CharGen actual por la de otro CharGen
     * @param otroGen el gen que provee la informacion
     */
    fun copiarDesdeCharGen(otroGen: CharGen)

    /**
     * funcion que permite sobreescribir informacion del MochilaGen actual por la de otro MochilaGen
     * @param otroGen el que provee la informacion
     */
    fun copiarDesdeMochilaGen(otroGen: MochilaGen)

    /**
     * funcion para comparar el contenido de dos genes
     */

    fun comparar(otroGen: Any): Boolean

    /**
     * funcion que crea una copia exacta del gen
     */
    fun copiarGen(): IGen<*>


}
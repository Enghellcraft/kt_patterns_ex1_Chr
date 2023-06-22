package Regalo

import java.time.DayOfWeek
import java.time.LocalDate

abstract class Regalo(var precio: Double, var marca: Marca?) {

    abstract var nombreRegalo: String
    var entregado: Boolean = false
    var regaloId: Int? = null
    fun esValioso(): Boolean = condicionGeneral() && condicionRegaloEspecifica()

    fun condicionGeneral(): Boolean = precio > 5000.0
    abstract fun condicionRegaloEspecifica(): Boolean
}

class Ropa(precio: Double, marca: Marca): Regalo(precio, marca) {
    override var nombreRegalo: String = "Ropa"
    var listaMarcasEspeciales: MutableList<Marca> = mutableListOf(Marca.LEE, Marca.JORDACHE, Marca.CHARRO, Marca.MOTOROIL)

    override fun condicionRegaloEspecifica(): Boolean = listaMarcasEspeciales.contains(marca!!)
}

class Juguetes(precio: Double, var fechaLanzamiento: LocalDate, marca: Marca ): Regalo(precio, marca) {
    override var nombreRegalo: String = "Juguete"
    var anioLimite: Int = 2000
    override fun condicionRegaloEspecifica(): Boolean = fechaLanzamiento.year < anioLimite
}

class Perfumes(precio: Double, var origen: Origen, marca: Marca): Regalo(precio, marca) {
    override var nombreRegalo: String = "Perfume"
    override fun condicionRegaloEspecifica(): Boolean = origen  == Origen.EXTRANJERO
}

class Experiencia(precio: Double, var fecha: LocalDate, marca: Marca): Regalo(precio, marca) {
    override var nombreRegalo: String = "Experiencia"
    override fun condicionRegaloEspecifica(): Boolean = fecha.dayOfWeek == DayOfWeek.FRIDAY
}

class Voucher(precio: Double = 2000.0, marca: Marca = Marca.PAPAPP): Regalo(precio, marca) {
    override var nombreRegalo: String = "Voucher"
    override fun condicionRegaloEspecifica(): Boolean = false
}


package Usuarios

import Regalo.Marca
import Regalo.Regalo

interface Gusto {
    fun leGusta(regalo: Regalo): Boolean
}

object Conformista: Gusto {
    override fun leGusta(regalo: Regalo): Boolean = true
}

class Interesada(var dinero: Double): Gusto {
    override fun leGusta(regalo: Regalo): Boolean = regalo.precio > dinero
}

object Exigente: Gusto {
    override fun leGusta(regalo: Regalo): Boolean = regalo.esValioso()
}

class Marquera(var marca: Marca): Gusto {
    override fun leGusta(regalo: Regalo): Boolean = regalo.marca == marca
}

class Combinetas: Gusto {
    var conjuntoCriterio = mutableListOf<Gusto>()

    override fun leGusta(regalo: Regalo): Boolean = conjuntoCriterio.any{ it.leGusta(regalo) }

    fun agregarConjuntoCriterio(gusto: Gusto) = conjuntoCriterio.add(gusto)
    fun eliminarConjuntoCriterio(gusto: Gusto) = conjuntoCriterio.remove(gusto)
}
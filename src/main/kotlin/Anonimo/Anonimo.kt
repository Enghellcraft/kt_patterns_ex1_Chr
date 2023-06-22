package Anonimo

import Observer.ObserverAccion
import Regalo.Regalo
import Regalo.Voucher
import Usuarios.Persona

object Anonimo {

    var regaloId = 0
    var listaAcciones: MutableList<ObserverAccion> = mutableListOf()
    var stockRegalos: MutableList<Regalo> = mutableListOf()

    fun regalosQueLeGustan(persona: Persona): List<Regalo> =
        stockRegalos.filter { persona.meGusta(it) }
    
    fun primerRegaloDisponible(persona: Persona): Regalo = regalosQueLeGustan(persona).first()

    fun noHayRegaloAdecuado(persona: Persona) = regalosQueLeGustan(persona).isEmpty()

    fun regaloFinal(persona: Persona) = if(noHayRegaloAdecuado(persona)) Voucher() else primerRegaloDisponible(persona)

    fun regalar(persona: Persona) {
        regaloFinal(persona).regaloId = regaloId++
        listaAcciones.toSet().forEach { it.notificar(persona, regaloFinal(persona)) }
        regaloFinal(persona).entregado = true
    }

    fun agregarObserver(observer: ObserverAccion) {
        listaAcciones.add(observer)
    }

    fun eliminarObserver(observer: ObserverAccion) {
        listaAcciones.remove(observer)
    }
}


package Usuarios

import Regalo.Regalo

class Persona(val gusto: Gusto, val direEmail: String, val direccion: String, val nombre: String, val dni: String) {

    fun meGusta(regalo: Regalo) = gusto.leGusta(regalo)
}
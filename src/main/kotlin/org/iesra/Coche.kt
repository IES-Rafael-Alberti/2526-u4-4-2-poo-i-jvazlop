package org.iesra

class Coche(
    marca: String?,
    modelo: String?,
    caballos: Int?,
    puertas: Int?,
    matricula: String?,
    color: String?
) {
    
    val marca: String

    val modelo: String

    val caballos: Int

    val puertas: Int

    val matricula: String

    var color: String = ""
        set(value) {
            if (value.isBlank()) {
                throw IllegalArgumentException("El color no puede ser nulo ni vacío")
            }
            field = value
        }

    init {
        if (marca.isNullOrBlank()) {
            throw IllegalArgumentException("La marca no puede ser nula ni vacía")
        }
        if (modelo.isNullOrBlank()) {
            throw IllegalArgumentException("El modelo no puede ser nulo ni vacío")
        }
        if (caballos == null || caballos !in 70..700) {
            throw IllegalArgumentException("Los caballos deben estar entre 70 y 700")
        }
        if (puertas == null || puertas !in 3..5) {
            throw IllegalArgumentException("Las puertas deben estar entre 3 y 5")
        }
        if (matricula == null || matricula.length != 7) {
            throw IllegalArgumentException("La matrícula debe tener exactamente 7 caracteres")
        }
        if (color.isNullOrBlank()) {
            throw IllegalArgumentException("El color no puede ser nulo ni vacío")
        }

        this.marca = marca.replaceFirstChar { it.uppercase() }
        this.modelo = modelo.replaceFirstChar { it.uppercase() }
        this.caballos = caballos
        this.puertas = puertas
        this.matricula = matricula
        this.color = color
    }

    override fun toString(): String {
        return "Coche(marca=$marca, modelo=$modelo, caballos=$caballos, puertas=$puertas, matricula=$matricula, color=$color)"
    }
}

fun main() {

    println(" COCHES QUE ESTAN BIEN")
    val c1 = Coche("ford", "focus", 120, 5, "1234ABC", "Rojo")
    val c2 = Coche("seat", "ibiza", 90, 3, "5678DEF", "Azul")

    println(c1)
    println(c2)

    println("\n PRUEBAS DEL ENUNCIADO")

    try {
        Coche(null, "Focus", 120, 5, "1234ABC", "Rojo")
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        Coche("Ford", "", 120, 5, "1234ABC", "Rojo")
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        Coche("Ford", "Focus", 50, 5, "1234ABC", "Rojo")
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        Coche("Ford", "Focus", 120, 2, "1234ABC", "Rojo")
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        Coche("Ford", "Focus", 120, 5, "12AB", "Rojo")
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        val coche = Coche("Ford", "Focus", 120, 5, "1234ABC", "Rojo")
        coche.color = ""
    } catch (e: Exception) {
        println(e.message)
    }
}

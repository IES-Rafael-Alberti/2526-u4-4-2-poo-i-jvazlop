package org.iesra

class Persona2(var peso: Double, altura: Double) {

    var nombre: String? = null

    var altura: Double = altura
        set(value) {
            if (value > 0) field = value
        }

    // IMC calculado (solo lectura)
    val imc: Double
        get() = peso / (altura * altura)

    // Constructor secundario con nombre
    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
    }

    /* ======================
       COMPORTAMIENTO NUEVO
       ====================== */

    fun saludar(): String {
        return "Hola, soy ${nombre ?: "una persona sin nombre"}"
    }

    fun alturaEncimaMedia(): Boolean = altura >= 1.75

    fun pesoEncimaMedia(): Boolean = peso >= 70

    // Método interno (solo uso de la clase)
    private fun obtenerDescImc(): String {
        return when {
            imc < 18.5 -> "peso insuficiente"
            imc < 25.0 -> "peso saludable"
            imc < 30.0 -> "sobrepeso"
            else -> "obesidad"
        }
    }

    fun obtenerDesc(): String {
        val descAltura = if (alturaEncimaMedia()) {
            "Por encima de la media"
        } else {
            "Por debajo de la media"
        }

        val descPeso = if (pesoEncimaMedia()) {
            "Por encima de la media"
        } else {
            "Por debajo de la media"
        }

        val imcFormateado = "%.2f".format(imc)

        return "${nombre ?: "Esta persona"} con una altura de ${altura}m ($descAltura) " +
                "y un peso ${peso}kg ($descPeso) tiene un IMC de $imcFormateado " +
                "(${obtenerDescImc()})"
    }

    override fun toString(): String {
        return "Persona2(nombre=$nombre, peso=$peso, altura=$altura, imc=${"%.2f".format(imc)})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona2) return false

        return peso == other.peso &&
                altura == other.altura &&
                nombre == other.nombre
    }
}

fun main() {

    val p1 = Persona2(70.0, 1.75)
    val p2 = Persona2("Luis", 82.0, 1.80)
    val p3 = Persona2("Julia", 64.7, 1.72)
    val p4 = Persona2("Ana", 55.0, 1.60)
    val p5 = Persona2("Carlos", 95.0, 1.78)

    // Pedir nombre a la persona 1
    var nombreValido: String?
    do {
        print("Introduce nombre para la persona 1: ")
        nombreValido = readLine()
    } while (nombreValido.isNullOrBlank())

    p1.nombre = nombreValido

    val personas = listOf(p1, p2, p3, p4, p5)

    println("\n--- LISTADO DE PERSONAS ---\n")

    for (persona in personas) {
        println(persona.saludar())
        println(persona.obtenerDesc())
        println()
    }
}

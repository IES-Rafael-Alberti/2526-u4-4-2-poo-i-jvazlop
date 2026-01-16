package org.iesra

class Rectangulo(base: Double, altura: Double) {

    val base: Double
    val altura: Double

    init {

        if (base <= 0 || altura <= 0) {
            throw IllegalArgumentException("Base y altura deben ser mayores que 0")
        }

        this.base = base

        this.altura = altura
    }

    fun area(): Double = base * altura

    fun perimetro(): Double = 2 * (base + altura)

    override fun toString(): String = "Rectángulo(base=$base, altura=$altura)"
}

fun main() {

    val r1 = Rectangulo(5.0, 3.0)

    val r2 = Rectangulo(10.0, 2.5)

    val r3 = Rectangulo(7.5, 7.5)

    val rectangulos = listOf(r1, r2, r3)

    for (r in rectangulos) {
        println(r)
        println("Área: ${r.area()}")
        println("Perímetro: ${r.perimetro()}")
        println("---------------------------------------------")
    }
}
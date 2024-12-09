package controllers

data class Punt(
    var x: Float,
    var y: Float
)
// 1.1. Procediment per mostrar un punt
fun mostraPunt(p: Punt) {
    println("(${p.x.format(6)}, ${p.y.format(6)})")
}
// Funció d'extensió per formatar els decimals
fun Float.format(digits: Int) = "%.${digits}f".format(this)
// 1.2. Procediment per translació
fun translacio(p: Punt, desplaçament: Punt) {
    p.x += desplaçament.x
    p.y += desplaçament.y
}
// 1.3. Procediment per escalat
fun escalat(p: Punt, factor: Float) {
    p.x *= factor
    p.y *= factor
}
// 1.4. Funció per comparar si dos punts són iguals
fun sonIguals(p1: Punt, p2: Punt): Boolean {
    return p1.x == p2.x && p1.y == p2.y
}
// Exemple d'ús
fun main() {
    val punt1 = Punt(2.0f, 0.2f)
    val punt2 = Punt(1.0f, 1.0f)
    // Mostrem el punt
    mostraPunt(punt1)
    // Translació
    translacio(punt1, punt2)
    mostraPunt(punt1) // Hauria de mostrar (3.000000, 1.200000)
    // Escalat
    escalat(punt1, 2.0f)
    mostraPunt(punt1) // Hauria de mostrar (6.000000, 2.400000)
    // Comparar punts
    val punt3 = Punt(6.0f, 2.4f)
    println("Punt1 i Punt3 són iguals? ${sonIguals(punt1, punt3)}") // Hauria de mostrar true
}
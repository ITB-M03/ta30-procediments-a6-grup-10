package controllers
import java.util.*
val FILAS = 20
val BUTAQUES = 15
fun mostrarMenu(scanner: Scanner): Int {
    println("\nMenú de reserva de seients:")
    println("1. Buidar sala")
    println("2. Visualitzar seients disponibles")
    println("3. Reserva de seients")
    println("0. Sortir")
    print("Selecciona una opció: ")
    return scanner.nextInt()
}
fun buidarSala(sala: Array<BooleanArray>) {
    for (fila in sala) {
        for (i in fila.indices) {
            fila[i] = false // Marquem tots els seients com a lliures
        }
    }
    println("La sala ha estat buidada.")
}
fun visualitzarSeients(sala: Array<BooleanArray>) {
    println("\nEstat dels seients:")
    for (i in sala.indices) {
        for (j in sala[i].indices) {
            if (sala[i][j]) {
                print("X ") // Seient reservat
            } else {
                print("_ ") // Seient lliure
            }
        }
        println()
    }
}
fun reservarSeient(sala: Array<BooleanArray>, scanner: Scanner) {
    println("Introdueix les coordenades del seient a reservar (fila i butaca):")
    print("Fila (0-${FILAS - 1}): ")
    val fila = scanner.nextInt()
    print("Butaca (0-${BUTAQUES - 1}): ")
    val butaca = scanner.nextInt()

    if (fila in 0 until FILAS && butaca in 0 until BUTAQUES) {
        if (!sala[fila][butaca]) {
            sala[fila][butaca] = true // Reservem el seient
            println("Seient reservat amb èxit.")
        } else {
            println("El seient ja està reservat.")
        }
    } else {
        println("Coordenades no vàlides. Si us plau, intenta-ho de nou.")
    }
}


fun main() {
    val sala = Array(FILAS) { BooleanArray(BUTAQUES) { false } } // false indica que el seient està lliure
    val scanner = Scanner(System.`in`)
    var opcio: Int
    do {
        opcio = mostrarMenu(scanner)
        when (opcio) {
            1 -> buidarSala(sala)
            2 -> visualitzarSeients(sala)
            3 -> reservarSeient(sala, scanner)
            0 -> println("Sortint del programa...")
            else -> println("Opció no vàlida. Si us plau, intenta-ho de nou.")
        }
    } while (opcio != 0)
}
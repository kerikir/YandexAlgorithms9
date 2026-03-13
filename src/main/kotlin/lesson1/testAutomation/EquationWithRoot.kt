package lesson1.testAutomation

fun main() {
    val a = readln().trim().toInt()
    val b = readln().trim().toInt()
    val c = readln().trim().toInt()

    calculateEquation(a, b, c).also(::println)
}


fun calculateEquation(a: Int, b: Int, c: Int): String {

    if (c < 0) return "NO SOLUTION"

    if (b == c * c) {
        return if (a == 0) "MANY SOLUTIONS" else "0"
    }

    if (a == 0) return "NO SOLUTION"

    val xDouble = (c * c - b) / a.toDouble()
    val xInt = (c * c - b) / a

    if (a * xDouble + b < 0) return "NO SOLUTION"

    return if (xDouble == xInt.toDouble()) {
        xInt.toString()
    } else {
        "NO SOLUTION"
    }
}
package lesson1.testAutomation


fun main() {
    val a = readln().trim().toInt()
    val b = readln().trim().toInt()
    val c = readln().trim().toInt()
    val d = readln().trim().toInt()

    calculationNumberOfPairs(a, b, c, d).also {
        println("${it.first} ${it.second}")
    }
}


fun calculationNumberOfPairs(a: Int, b: Int, c: Int, d: Int): Pair<Int, Int> {

    return if (a + c < b + d) {
        (a + 1) to (c + 1)
    } else {
        b + 1 to d + 1
    }
}
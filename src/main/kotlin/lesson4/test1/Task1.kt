package lesson4.test1

fun main() {
    val (n, m) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val array = mutableListOf<CharArray>().apply {
        repeat(n) {
            val tempArray = readln().trim().toCharArray()
            add(tempArray)
        }
    }

    val points = mutableSetOf<Pair<Int, Int>>()
    for ((i, row) in array.withIndex()) {
        for ((j, char) in row.withIndex()) {
            if (char == '#') {
                points.add(i + 1 to j + 1)
            }
        }
    }

    var counter = 0
    var currLength = 0
    val copyPoints = points.toSet()
    for ((x, y) in copyPoints) {
        if (Pair(x + 1, y) in points) {
            points.remove(Pair(x + 1, y))
        }
        if (Pair(x, y + 1) in points) {
            points.remove(Pair(x, y + 1))
        }
        if (Pair(x + 1, y + 1) in points) {
            points.remove(Pair(x + 1, y + 1))
        }
    }

    points.size.also(::println)
}
package lesson2.test3

fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()

    val ban = mutableSetOf<Int>()
    for (i in 0..<n) {
        val rotate = (i - array[i] + 1) % n
        ban.add(rotate)
    }

    repeat(n) {
        if (it !in ban) {
            println(it)
            return
        }
    }

    println(-1)
}
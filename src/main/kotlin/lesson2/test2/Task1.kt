package lesson2.test2

fun main() {
    val n = readln().trim().toInt()
    val position = mutableListOf<MutableSet<Int>>()
    repeat(n) {
        val (x, d) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        mutableSetOf<Int>().apply {
            for (i in (x-d)..(x+d)) {
                add(i)
            }
        }.also {
            position.add(it)
        }
    }

    var result = position.first().toSet()
    for (i in 1..<n) {
        result = result.intersect(position[i])
    }

    if (result.isNotEmpty()) {
        result.max().also {
            if (it >= 0) {
                println(it)
            } else {
                println(-1)
            }
        }
    } else {
        println(-1)
    }
}
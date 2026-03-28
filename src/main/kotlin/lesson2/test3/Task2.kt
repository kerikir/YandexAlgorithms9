package lesson2.test3

fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()

    repeat(n) {
        if (isCorrect(n, array, it)) {
            println(it)
            return
        }
    }

    println(-1)
}


fun isCorrect(n: Int, array: IntArray, shift: Int): Boolean {
    var flag = true

    for (i in 0..<n) {
        val food = array[(i+ shift) % n]
        flag = flag && (food != (i + 1))

        if (!flag) {
            return false
        }
    }

    return flag
}
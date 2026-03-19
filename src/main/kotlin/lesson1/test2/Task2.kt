package lesson1.test2

import kotlin.math.ceil


fun main() {
    var (n, m, h, w) = readln().trim().split(Regex("\\s+")).map { it.toLong() }

    var counter = 0

    while (!isCorrect(n, m, h, w)) {

        if (h < n && h < m) {
            h *= 2
            counter++
        } else if (w < n && w < m) {
            w *= 2
            counter++
        } else if (h in m..<n) {
            w *= 2
            counter++
        } else if (w in m..<n) {
            counter++
            h *= 2
        }
    }

    println(counter)
}


fun isCorrect(n: Long, m: Long, h: Long, w: Long): Boolean {
    return (n <= h && m <= w) || (n <= w && m <= h)
}
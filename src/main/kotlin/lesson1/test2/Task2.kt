package lesson1.test2

import kotlin.math.ceil


fun main() {
    var (n, m, h, w) = readln().trim().split(Regex("\\s+")).map { it.toLong() }

    var counter = 0

    while (!isCorrect(n, m, h, w)) {

        if (n > h && n > w) {
            n = ceil(n / 2.0).toLong()
        } else if (m > h && m > w) {
            m = ceil(m / 2.0).toLong()
        } else if ((m > h && n > w) || (m > w && n > h)) {
            if (m > n) {
                m = ceil(m / 2.0).toLong()
            } else {
                n = ceil(n / 2.0).toLong()
            }
        } else if ((n > h && m <= w) || (n > w && m <= h)) {
            n = ceil(n / 2.0).toLong()
        } else if ((m > h && n <= w) || (m > w && n <= h)) {
            m = ceil(m / 2.0).toLong()
        }

        counter++
    }

    println(counter)
}


fun isCorrect(n: Long, m: Long, h: Long, w: Long): Boolean {
    return (n <= h && m <= w) || (n <= w && m <= h)
}
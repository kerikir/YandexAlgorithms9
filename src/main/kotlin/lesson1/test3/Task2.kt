package lesson1.test3

import kotlin.math.*

fun main() {
    val n = readln().trim().toLong()

    var columns = 1L
    var minDiff = n

    while (columns * columns < 2 * n) {

        if (n % columns == 0L) {
            minDiff = min(minDiff, abs(columns - (n / columns)))

        } else {
            val minColumn = n / columns
            val extra = n - columns * minColumn

            if (columns / 2 == extra || (columns + 1) / 2 == extra) {
                minDiff = min(minDiff, abs(columns - (minColumn + 1)))
            }
        }

        columns++
    }

    println(minDiff)
}
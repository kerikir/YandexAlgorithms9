package lesson1.test3

import kotlin.math.*

fun main() {
    val n = readln().trim().toLong()

    var rows = 1L
    var minDiff = n

    while (rows * rows < 2 * n) {

        if (n % rows == 0L) {
            minDiff = min(minDiff, abs(rows - (n / rows)))

        } else {
            val minColumn = n / rows
            val extra = n - rows * minColumn

            if (rows / 2 == extra || (rows + 1) / 2 == extra) {
                minDiff = min(minDiff, abs(rows - (minColumn + 1)))
            }
        }

        rows++
    }

    println(minDiff)
}
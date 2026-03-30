package lesson3.twoPointers

import kotlin.math.abs

fun main() {
    val n = readln().trim().toInt()
    val list = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val tables = LongArray(n)
    tables[0] = list.first().toLong()
    for (i in 1..<n) {
        tables[i] = tables[i - 1] + list[i]
    }

    val tablesReversed = LongArray(n)
    tablesReversed[0] = list.last().toLong()
    for (i in 1..<n) {
        tablesReversed[i] = tablesReversed[i - 1] + list[list.lastIndex - i]
    }


    var l = 0
    var r = 0
    var minL = -1
    var minR = -1

    var currentDiff = -1L
    var minDiff = Long.MAX_VALUE

    while (l < n - 1 - r) {
        if (l < n - 1 && (tables[l] < tablesReversed[r] || r == n - 1)) {
            l++
        } else {
            r++
        }

        currentDiff = abs(tables[l] - tablesReversed[r])
        if (currentDiff < minDiff) {
            minDiff = currentDiff
            minL = l + 1
            minR = n - r
        }
    }

    println("$minDiff $minL $minR")
}
package lesson3.test3

import kotlin.math.max


fun main() {
    val (n, k) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    var price = readln().trim()
        .split(Regex("\\s+"))
        .map { it.toLong() }
        .toMutableList()
        .apply { addFirst(0L) }

    val prefixSum = LongArray(n + 1)
    prefixSum[0] = 0L
    for (i in 1..n) {
        prefixSum[i] = prefixSum[i - 1] + price[i]
    }

    var minArray = mutableListOf(0L)
    var max = 0L

    for (i in 1..prefixSum.lastIndex) {

        minArray.add(prefixSum[i])
        minArray.sort()

        for (j in minArray.lastIndex until 0) {
            if (remainOfDivision(minArray[j], k) == remainOfDivision(minArray[j - 1], k)) {
                minArray.removeAt(j)
                break
            }
        }

        minArray = minArray.take(2).toMutableList()

        for (min in minArray) {
            if (remainOfDivision(min, k) != remainOfDivision(prefixSum[i], k)) {
                max = max(max, prefixSum[i] - min)
            }
        }
    }

    println(max)
}


fun remainOfDivision(number: Long, mod: Int): Long {

    val remain = number % mod

    return if (remain  >= 0) {
        remain
    } else {
        mod + remain
    }
}
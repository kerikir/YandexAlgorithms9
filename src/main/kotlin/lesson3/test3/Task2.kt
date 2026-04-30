package lesson3.test3

import kotlin.math.max


fun main() {
    val (n, k) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val price = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val prefixSum = LongArray(n + 1)
    prefixSum[0] = 0L
    for (i in 1..n) {
        prefixSum[i] = prefixSum[i - 1] + price[i]
    }

    var minArray = mutableListOf<Long>(0L)
    var max = 0L

    for (i in 1..prefixSum.lastIndex) {

        minArray.add(prefixSum[i])
        minArray.sort()

        for (j in minArray.lastIndex until 0) {
            if (minArray[j] % k == minArray[j - 1] % k) {
                minArray.removeAt(j)
                break
            }
        }

        minArray = minArray.take(2).toMutableList()

        max = if (minArray.first() % k == prefixSum[i] % k) {
            max(max, prefixSum[i] - minArray.last())
        } else {
            max(max, prefixSum[i] - minArray.first())
        }
    }

    println(max)
}
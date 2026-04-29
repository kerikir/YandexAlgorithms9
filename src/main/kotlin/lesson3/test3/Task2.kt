package lesson3.test3

import kotlin.math.max


fun main() {
    val (n, k) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val price = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val prefixSum = LongArray(n)
    prefixSum[0] = price.first().toLong()
    for (i in 1..<n) {
        prefixSum[i] = prefixSum[i - 1] + price[i]
    }

    var minArray = mutableListOf<Long>(0)
    var max = 0L

    for (i in prefixSum.indices) {

        minArray.add(prefixSum[i])

        minArray.sort()
        if (minArray.size > 2 && minArray[1] % k == minArray.first() % k) {
            minArray.removeAt(1)
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
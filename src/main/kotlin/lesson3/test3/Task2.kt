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

    var min1 = 0L
    var min2 = 1L
    var max = 0L

    for (i in prefixSum.indices) {
        if (prefixSum[i] < min1 && prefixSum[i] % k == min1 % k) {
            min1 = prefixSum[i]

        } else if (prefixSum[i] < min1) {
            min2 = min1
            min1 = prefixSum[i]

        } else if (prefixSum[i] < min2 && prefixSum[i] % k != min1 % k) {
            min2 = prefixSum[i]
        }

        max = if (min1 % k == prefixSum[i] % k) {
            max(max, prefixSum[i] - min2)
        } else {
            max(max, prefixSum[i] - min1)
        }
    }

    println(max)
}
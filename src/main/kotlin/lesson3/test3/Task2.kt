package lesson3.test3

import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, k) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val price = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val prefixSum = LongArray(n)
    prefixSum[0] = price.first().toLong()
    for (i in 1..<n) {
        prefixSum[i] = prefixSum[i - 1] + price[i]
    }

    var maxSum = if (prefixSum[0] % k != 0L) {
        prefixSum.first()
    } else {
        Long.MIN_VALUE
    }
    var prevMin = 0L

    for (i in 0..<n) {
        if ((prefixSum[i] - prevMin) % k != 0L) {
            maxSum = max(maxSum, prefixSum[i] - prevMin)
        }
        prevMin = min(prevMin, prefixSum[i])
    }

    if (maxSum < 0) {
        println(0)
    } else {
        println(maxSum)
    }
}
package lesson3.prefixAmounts

import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().trim().toInt()
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val prefixSum = LongArray(n)
    prefixSum[0] = numbers.first().toLong()
    for (i in 1..<n) {
        prefixSum[i] = prefixSum[i - 1] + numbers[i]
    }

    var maxSum = prefixSum.first()
    var prevMin = 0L
    for (i in 0..<n) {
        maxSum = max(maxSum, prefixSum[i] - prevMin)
        prevMin = min(prevMin, prefixSum[i])
    }

    println(maxSum)
}
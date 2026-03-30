package lesson3.prefixAmounts

fun main() {
    val n = readln().trim().toInt()
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val prefixSum = LongArray(n)
    prefixSum[0] = numbers.first().toLong()
    for (i in 1..<n) {
        prefixSum[i] = prefixSum[i - 1] + numbers[i]
    }

    val prefixSumReversed = LongArray(n)
    prefixSum[0] = numbers.last().toLong()
    for (i in 1..<n) {
        prefixSum[i] = prefixSum[i - 1] + numbers[n - 1 - i]
    }

    val prefixSumNonNegative = LongArray(n)
    prefixSumNonNegative[0] = if (numbers.first() < 0) 0L else numbers.first().toLong()
    for (i in 1..<n) {
        if (numbers[i] < 0) {
            prefixSumNonNegative[i] = 0
        } else {
            prefixSumNonNegative[i] = prefixSumNonNegative[i - 1] + numbers[i]
        }
    }

    maxOf(prefixSum.max(), prefixSumReversed.max(), prefixSumNonNegative.max()).also(::println)
}
package lesson3.prefixAmounts

fun main() {
    val n = readln().trim().toInt()
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toLong() }

    val mod = 1_000_000_007L

    val prefixSum = LongArray(n)
    prefixSum[0] = numbers.first().toLong()
    for (i in 1..<n) {
        prefixSum[i] = (prefixSum[i - 1] + numbers[i]) % mod
    }

    val suffixSum = LongArray(n)
    suffixSum[n - 1] = numbers.last().toLong()
    for (i in (n - 2) downTo 0) {
        suffixSum[i] = (suffixSum[i + 1] + numbers[i]) % mod
    }

    var result = 0L
    for (i in 1..(n - 2)) {
        result = (result + prefixSum[i - 1] * numbers[i] * suffixSum[i + 1]) % mod
    }

    println(result)
}
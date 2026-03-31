package lesson3.prefixAmounts

fun main() {
    val n = readln().trim().toInt()
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val mod = 1_000_000_007

    val prefixSum = IntArray(n)
    prefixSum[0] = numbers.first()
    for (i in 1..<n) {
        prefixSum[i] = (prefixSum[i - 1] + numbers[i]) % mod
    }

    val suffixSum = IntArray(n)
    suffixSum[0] = numbers.last()
    for (i in 1..<n) {
        suffixSum[i] = (suffixSum[i - 1] + numbers[n - 1 - i]) % mod
    }

    var result = 0
    for (i in 1..(n - 2)) {
        result = (result + prefixSum[i - 1] * numbers[i] * suffixSum[n - i - 2]) % mod
    }

    println(result)
}
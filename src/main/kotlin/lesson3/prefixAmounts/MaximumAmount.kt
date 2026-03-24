package lesson3.prefixAmounts

fun main() {
    val n = readln().trim().toInt()
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val prefixSum = LongArray(n)
    prefixSum[0] = numbers.first().toLong()
    for (i in 1..<n) {
        prefixSum[i] = prefixSum[i - 1] + numbers[i]
    }

    var maxSum = Long.MIN_VALUE
    for (i in 0..<n) {
        for (j in i..<n) {
            if (i > 0) {
                val sum = prefixSum[j] - prefixSum[i - 1]
                if (sum > maxSum) {
                    maxSum = sum
                }
            } else {
                val sum = prefixSum[j]
                if (sum > maxSum) {
                    maxSum = sum
                }
            }
        }
    }

    println(maxSum)
}
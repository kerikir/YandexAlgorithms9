package lesson3.prefixAmounts

fun main() {
    val n = readln().trim().toInt()
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val prefixSum = IntArray(n)
    prefixSum[0] = numbers.first()
    for (i in 1..<n) {
        prefixSum[i] = prefixSum[i - 1] + numbers[i]
    }

    println(prefixSum.joinToString(" "))
}
package lesson3.prefixAmounts

fun main() {
    val n = readln().trim().toInt()
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toLong() }
    val q = readln().trim().toInt()
    val x0 = readln().trim().toLong()

    val mod = 1_000_000_007L

    val prefixSum = LongArray(n)
    prefixSum[0] = numbers.first()
    for (i in 1..<n) {
        prefixSum[i] = prefixSum[i - 1] + numbers[i]
    }

    val x = LongArray(2 * n)
    x[0] = x0
    for (i in 1..x.lastIndex) {
        x[i] = (11_173L * x[i - 1] + 1) % mod
    }
}
package lesson3.prefixAmounts

fun main() {
    val n = readln().trim().toInt()
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val mod = 1_000_000_007
    val array = LongArray(n - 2)

    for (i in 0..<(n - 2)) {
        array[i] = (numbers[i].toLong() * numbers[i + 1] * numbers[i + 2]) % mod
    }

    var min = Long.MAX_VALUE
    var counterNegative = 0

    var sum = 0L
    for (i in 0..<(n - 2))  {
        if (min > array[i]) {
            min = array[i]
        }

        if (array[i] < 0) {
            counterNegative++
        }

        sum = (sum + array[i]) % mod
    }

    val result = if (min < 0 && (counterNegative % 2) == 1) {
        (sum + min) % mod
    } else {
        sum
    }
    println(result)
}
package lesson3.prefixAmounts

fun main() {
    val (n, k) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    var counter = 0
    var left = 0
    var right = 0

    var sum = 0
    while (left < n && right < n) {
        sum += numbers[right]

        while (sum > k && left <= right) {
            sum -= numbers[left]
            left++
        }

        if (sum == k) counter++
        right++
    }

    println(counter)
}
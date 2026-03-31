package lesson3.prefixAmounts

import kotlin.math.max
import kotlin.math.min


/*

Задача: Сумма на отрезке без изменений - определить остаток от деления суммы ответов на все запросы

Сложность = O(N + Q) = O(N)
Ограничения: 1 <= N <= 100_000
             0 <= Ai <= 1_000_000_000
             1 <= Q <= 10_000
             0 <= X0 <= 1_000_000_000

Время = 272ms
Память = 27.46MB

 */


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

    val x = LongArray(2 * q)
    x[0] = x0
    for (i in 1..x.lastIndex) {
        x[i] = (11_173L * x[i - 1] + 1L) % mod
    }

    var sum = 0L
    for (i in 0..<q) {
        val left = min(x[2 * i] % n.toLong(), x[2 * i + 1] % n.toLong()).toInt()
        val right = max(x[2 * i] % n.toLong(), x[2 * i + 1] % n.toLong()).toInt()

        val result = if (left > 0) {
            prefixSum[right] - prefixSum[left - 1]
        } else {
            prefixSum[right]
        }
        sum = (sum + result) % mod
    }

    println(sum)
}
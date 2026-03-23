package lesson3.prefixAmounts

/*

Задача: Префиксные суммы - составить последовательность префиксных сумм для последовательности чисел

Сложность = O(N)
Ограничения: 1 <= N <= 1_000
             -1_000_000 <= Ai <= 1_000_000

Время = 190ms
Память = 25.91MB

 */


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
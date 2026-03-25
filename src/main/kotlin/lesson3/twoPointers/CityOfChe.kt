package lesson3.twoPointers

/*

Задача: Город Че - определение количества способов выбора двух различных памятников для организации свиданий

Сложность = O(N)
Ограничения: 2 <= N <= 300_000
             1 <= r <= 1_000_000_000
             1 <= d <= 1_000_000_000

Время = 684ms
Память = 58.66MB

 */


fun main() {
    val (n, r) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val d = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val distances = IntArray(n)
    for (i in 0..<n) {
        distances[i] = d[i] - d[0]
    }

    var counter = 0L

    var right = 0
    for (left in 0..<n) {
        while (right < n) {

            val distance = distances[right] - distances[left]
            if (distance > r) {
                counter += n - right
                break
            } else {
                right++
            }
        }
    }

    println(counter)
}
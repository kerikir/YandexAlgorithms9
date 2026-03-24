package lesson3.prefixAmounts

/*

Задача: Сумма номеров - определение количества подряд идущих машин с необходимой суммой номеров

Сложность = O(N)
Ограничения: 1 <= N <= 100_000
             1 <= K <= 1_000_000_000
             1 <= Ai <= 999

Время = 415ms
Память = 34.21MB

 */


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
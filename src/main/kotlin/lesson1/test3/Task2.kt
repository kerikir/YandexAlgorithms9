package lesson1.test3

import kotlin.math.*


/*

Задача: Экзамен в бункере - определить минимальный модуль разности числа рядов и максимального числа
        студентов в одном ряду

Сложность = O(logN)
Ограничения: 1 <= N <= 1_000_000_000_000

Время = 131ms
Память = 19.85MB

 */


fun main() {
    val n = readln().trim().toLong()

    var rows = 1L
    var minDiff = n

    while (rows * rows < 2 * n) {

        if (n % rows == 0L) {
            minDiff = min(minDiff, abs(rows - (n / rows)))

        } else {
            val minColumn = n / rows
            val extra = n - rows * minColumn

            if (rows / 2 == extra || (rows + 1) / 2 == extra) {
                minDiff = min(minDiff, abs(rows - (minColumn + 1)))
            }
        }

        rows++
    }

    println(minDiff)
}
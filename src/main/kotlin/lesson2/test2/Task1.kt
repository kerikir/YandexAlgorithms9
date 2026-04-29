package lesson2.test2

/*

Задача: Поиски ровера - определить максимальное положение ровера

Сложность = O(N)
Ограничения: 1 <= N <= 100_000
             0 <= X, D <= 1_000_000_000

Время = 742ms
Память = 42.66MB

 */


fun main() {
    val n = readln().trim().toInt()

    var left = 0
    var right = Int.MAX_VALUE

    repeat(n) {
        val (x, d) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        val a = x - d
        val b = x + d

        if (left < a) {
            left = a
        }
        if (right > b) {
            right = b
        }
    }


    if (right >= left) {
        println(right)
    } else {
        println(-1)
    }
}
package lesson2.setWorking

/*

Задача: Разные числа - определить количество различных чисел

Сложность = O(N)
Ограничения: 0 <= N <= 100_000

Время = 448ms
Память = 37.02MB

 */


fun main() {
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val set = numbers.toSet()
    println(set.size)
}
package lesson2.test3

/*

Задача: Не в своей тарелке - определить минимальное число операций поворота стола,
        чтобы ни один гость не получил блюда, на которое у него аллергия.

Сложность = O(N)
Ограничения: 0 <= N <= 200_000
             0 <= Ai <= 200_000

Время = 679ms
Память = 54.75MB

 */


fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()

    val ban = mutableSetOf<Int>()
    for (i in 0..<n) {
        val rotate = (array[i] - i - 1 + n) % n
        ban.add(rotate)
    }

    repeat(n) {
        if (it !in ban) {
            println(it)
            return
        }
    }

    println(-1)
}
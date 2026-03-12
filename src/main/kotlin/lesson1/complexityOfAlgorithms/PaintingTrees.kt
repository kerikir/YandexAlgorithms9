package lesson1.complexityOfAlgorithms

/*

Задача: Покраска деревьев - отход от ведра краски

Сложность = O(1)
Ограничения: все числа по модулю <= 100_000_000

Время = 124ms
Память = 20.88MB

 */


fun main() {
    val (p, v) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val (q, m) = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val x1 = p - v
    val x2 = p + v
    val y1 = q - m
    val y2 = q + m

    var doublePaint = 0
    if (x1 <= y1 && y2 <= x2) {
        doublePaint = y2 - y1 + 1
    } else if (y1 <= x1 && x2 <= y2) {
        doublePaint = x2 - x1 + 1
    } else if (x2 >= y1 && p < q) {
        doublePaint = x2 - y1 + 1
    } else if (y2 >= x1 && q < p) {
        doublePaint = y2 - x1 + 1
    }

    val result = (x2 - x1 + 1) + (y2 - y1 + 1) - doublePaint
    println(result)
}
package lesson1.testAutomation

/*

Задача: Пара одноцветной одежды - найти минимальное число вытягиваний для комплекта в одном цвете

Сложность = O(1)
Ограничения: 1 <= N <= 1_000_000_000

Время = 101ms
Память = 19.85MB

 */



fun main() {
    val a = readln().trim().toInt()
    val b = readln().trim().toInt()
    val c = readln().trim().toInt()
    val d = readln().trim().toInt()

    calculationNumberOfPairs(a, b, c, d).also {
        println("${it.first} ${it.second}")
    }
}


fun calculationNumberOfPairs(a: Int, b: Int, c: Int, d: Int): Pair<Int, Int> {

    if (a == 0 && c != 0) {
        return b to d + 1
    }
    if (a != 0 && c == 0) {
        return b + 1 to d
    }
    if (a == 0 && c == 0) {
        return b to d
    }

    if (b == 0 && d == 0) {
        return a to c
    }
    if (b == 0 && d != 0) {
        return a to (c + 1)
    }
    if (b != 0 && d == 0) {
        return (a + 1) to c
    }

    return if (a + c < b + d) {
        (a + 1) to (c + 1)
    } else {
        b + 1 to d + 1
    }
}
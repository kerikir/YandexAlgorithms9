package lesson1.testAutomation

import kotlin.math.max

/*

Задача: Пара одноцветной одежды - найти минимальное число вытягиваний для комплекта в одном цвете

Сложность = O(1)
Ограничения: 0 <= A, B, C, D <= 1_000_000_000

Время = 102ms
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

    if (a == 0 && c == 0) {
        return 1 to 1
    }
    if (b == 0 && d == 0) {
        return 1 to 1
    }

    if (a == 0) {
        return 1 to c + 1
    }
    if (c == 0) {
        return a + 1 to 1
    }

    if (b == 0) {
        return 1 to d + 1
    }
    if (d == 0) {
        return b + 1 to 1
    }

    if (a == b && c == d) {
        return if (a < c) {
            a + 1 to 1
        } else {
            1 to c + 1
        }
    }

    if (a == b) {
        return a + 1 to 1
    }
    if (c == d) {
        return 1 to c + 1
    }

    val maxShirt = max(a, b) + 1
    val maxSock = max(c, d) + 1

    if ((maxShirt + 1 < a + c) && (maxShirt + 1 < b + d) && (maxShirt <= maxSock)) {
        return maxShirt to 1
    }
    if ((maxSock + 1 < a + c) && (maxSock + 1 < b + d) && (maxSock < maxShirt)) {
        return 1 to maxSock
    }

    return if (a + c < b + d) {
        (a + 1) to (c + 1)
    } else {
        b + 1 to d + 1
    }
}
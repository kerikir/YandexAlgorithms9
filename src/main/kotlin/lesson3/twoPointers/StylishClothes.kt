package lesson3.twoPointers

import kotlin.math.abs


/*

Задача: Стильная одежда - определение максимально стильной одежды, разница цветов которых минимальна

Сложность = O(N + M) = O(N)
Ограничения: 1 <= N <= 100_000
             1 <= M <= 100_000
             1 <= Ai <= 10_000_000

Время = 610ms
Память = 43.41MB

 */


fun main() {
    val n = readln().trim().toInt()
    val tShirts = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val m = readln().trim().toInt()
    val pants = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    var minDifference = abs(tShirts[0] - pants[0])
    var colorTShirt = tShirts[0]
    var colorPants = pants[0]

    var secondPointer = 0
    for (firstPointer in 0..<n) {
        while (secondPointer < m) {

            val currentDifference = abs(tShirts[firstPointer] - pants[secondPointer])

            if (currentDifference < minDifference) {
                minDifference = currentDifference
                colorTShirt = tShirts[firstPointer]
                colorPants = pants[secondPointer]
            }

            if (tShirts[firstPointer] < pants[secondPointer]) {
                break
            } else {
                secondPointer++
            }
        }
    }

    println("$colorTShirt $colorPants")
}
package lesson3.test3

import kotlin.math.floor

fun main() {
    val string = readln().trim()

    val evaluations = mutableMapOf<Char, Int>()
    for (char in string) {
        evaluations[char] = evaluations.getOrDefault(char, 0) + 1
    }

    val charMin = string.max()

    var sum = 0
    var counter = 0
    for (score in evaluations) {
        sum += score.key.code * score.value
        counter += score.value
    }

    var score = sum.toDouble() / counter
    val floor = floor(score)
    val diff = score - floor
    val calculateScore = if (diff == 0.5) {
        floor.toInt()
    } else {
        (sum + counter - 1) / counter
    }

    if (calculateScore >= charMin.code - 1) {
        println(calculateScore.toChar())
    } else {
        println((charMin.code - 1).toChar())
    }
}
package lesson3.test3

import kotlin.math.floor
import kotlin.math.round

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

    val score = sum.toDouble() / counter
    val floor = floor(score)
    val calculateScore = if (score - floor == 0.5) {
        floor.toInt()
    } else {
        round(score).toInt()
    }

    if (calculateScore >= charMin.code - 1) {
        println(calculateScore.toChar())
    } else {
        println((charMin.code - 1).toChar())
    }
}
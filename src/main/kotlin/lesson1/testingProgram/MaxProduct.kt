package lesson1.testingProgram

import kotlin.math.max
import kotlin.math.min


fun main() {
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    maxProduct(numbers).also {
        println("${it.first} ${it.second}")
    }
}


fun maxProduct(numbers: List<Int>): Pair<Int, Int> {

    var min1 = min(numbers[0], numbers[1])
    var min2 = max(numbers[0], numbers[1])
    var max1 = min2
    var max2 = min1

    for (i in 2..numbers.lastIndex) {

        if (numbers[i] > max1) {
            max2 = max1
            max1 = numbers[i]

        } else if (numbers[i] > max2) {
            max2 = numbers[i]
        }

        if (numbers[i] < min1) {
            min2 = min1
            min1 = numbers[i]

        } else if (numbers[i] < min2) {
            min2 = numbers[i]
        }
    }

    val productMinNumbers: Long = min1 * min2.toLong()
    val productMaxNumbers: Long = max1 * max2.toLong()

    return if (productMinNumbers >= productMaxNumbers) {
        min1 to min2
    } else {
        max2 to max1
    }
}
package lesson1.test3

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    val n = readln().trim().toLong()

    val minLength = floor(sqrt(n.toDouble())).toLong()
    val maxLength = ceil(sqrt(n.toDouble())).toLong()

    if (n == (maxLength * maxLength)) {
        println(0)
        return
    }

    var additionalPlaceOdd = maxLength / 2
    var additionalPlaceEven = (maxLength + 1) / 2

    if (n == (maxLength * maxLength - additionalPlaceOdd) || n == (maxLength * maxLength - additionalPlaceEven)) {
        println(0)
        return
    }

    if (n == minLength * maxLength) {
        println(1)
        return
    }
}